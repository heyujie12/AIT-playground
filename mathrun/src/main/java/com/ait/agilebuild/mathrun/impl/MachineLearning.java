package com.ait.agilebuild.mathrun.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ait.agilebuild.mathrun.api.IMachineLearning;
import com.ait.agilebuild.mathrun.api.IMathRunDao;
import com.ait.agilebuild.mathrun.api.IQuestionsGenerator;
import com.ait.agilebuild.mathrun.model.Distribution;
import com.ait.agilebuild.mathrun.model.Progression;
import com.ait.agilebuild.mathrun.model.QuestionDefinition;
import com.ait.agilebuild.mathrun.model.Student;

@Stateless
public class MachineLearning implements IMachineLearning{
	public static final long QUESTION_TIME_SPAN = 8000;
	@Inject
	private IQuestionsGenerator qGenerator;
	@Inject
	private IMathRunDao mathrunDao;

	@Override
	public QuestionDefinition produceNextQuestion(Progression<QuestionDefinition> p){
		if(p == null){
			throw new IllegalArgumentException("Progression can not be null");
		}
		if(p.size() == 0){
			throw new IllegalArgumentException("Progression size can not be zero");
		}
		// Machine learning
		List<QuestionDefinition> questions = findQuestionsWithSameLevel(p);
		int level = analyzeNextDiffcultLevel(questions);
		QuestionDefinition nextQuestion = qGenerator.getQuestion(level); //use level as argument
		return nextQuestion;
	}
	
	private List<QuestionDefinition> findQuestionsWithSameLevel(Progression<QuestionDefinition> p){
		List<QuestionDefinition> list = new ArrayList<>();
		int lastDifLevel = p.get(p.size() - 1).getDifficulty_level();
		for(int i = p.size() - 1; i>=0; i--){
			if(lastDifLevel == p.get(i).getDifficulty_level()){
				list.add(p.get(i));
			}else{
				break;
			}
		}
		return list;
	}
	
	private int analyzeNextDiffcultLevel(List<QuestionDefinition> list){
		int difLevel = list.get(0).getDifficulty_level();
		int result = 0;
		int offset = 0;
		for(int i = list.size() - 1; i>=0; i--){
			QuestionDefinition q = list.get(i);
			float finalAttemp = q.getAttempts().get(q.getAttempts().size() - 1);
			if(finalAttemp != q.getCorrect_answer()){
				// when question is answered incorrectly
				if(result > 0){
					result = 0;
				}
				result -= 5;
			}else{
				// when question is answered correctly
				result += calcQuestionGain(q);
			}
			if(result >= 10){
				offset = 1;
				break;
			}else if(result <= -10){
				offset = -1;
				break;
			}
		
		}
		return difLevel + offset;
	}

	private int calcQuestionGain(QuestionDefinition q) {
		if(q.getAttempts().size() == 1){
			if(q.getTime() < QUESTION_TIME_SPAN * 0.3){
				return 5;
			}else if(q.getTime() < QUESTION_TIME_SPAN * 0.7){
				return 4;
			}else if(q.getTime() < QUESTION_TIME_SPAN){
				return 2;
			}
		}else if(q.getAttempts().size() > 1){
			return 1;
		}
		return 0;
	}
	
	private void checkListValidity(List<?> list){
		if(list == null || list.size() == 0){
			throw new IllegalArgumentException("Null list or empty list is invalid input");
		}
	}

	private Map<Integer, List<QuestionDefinition>> groupByDifficultLevel(List<QuestionDefinition> list) {
		checkListValidity(list);
		Map<Integer, List<QuestionDefinition>> classification = new HashMap<>();
		for(QuestionDefinition q : list){
			final int qLevel = q.getDifficulty_level();
			if(classification.get(qLevel) == null){
				classification.put(qLevel, new ArrayList<QuestionDefinition>());
			}
			classification.get(qLevel).add(q);
		}
		return classification;
	}

	private static final double INVALID_AVG = 1;
	@Override
	public Map<Integer, Double> generateLevelProficiency(
			long studentId) {
		Map<Integer, Double> result = new HashMap<>();
		
		Student student = mathrunDao.getStudentById(studentId);
		Map<Integer, List<QuestionDefinition>> classification = groupByDifficultLevel(student.getAllQuestions());

		for(Entry<Integer, List<QuestionDefinition>> entry : classification.entrySet()){
			List<Double> values = new ArrayList<>();
			final int level = entry.getKey();
			List<QuestionDefinition> allQuestionsInLevel = mathrunDao.getQuestionsByLevel(level);
			Map<Long, List<QuestionDefinition>> questionsPerStudent = groupByStudent(allQuestionsInLevel);

			for(Entry<Long, List<QuestionDefinition>> studentEntry : questionsPerStudent.entrySet()){
				double avg = getAvgAccurarcy(studentEntry.getValue());
				if(avg != INVALID_AVG){
					values.add(avg);
				}
			}
			Distribution d = new Distribution(values);
			double proficiency = Distribution.cumulativeProbability(d, getAvgAccurarcy(entry.getValue()));
			result.put(level, proficiency);
		}
		
		return result;
	}
	
	private Map<Long, List<QuestionDefinition>> groupByStudent(List<QuestionDefinition> questions) {
		Map<Long, List<QuestionDefinition>> classification = new HashMap<>();
		for(QuestionDefinition q : questions){
			final long student = q.getGame().getStudent().getIdStudent();
			if(classification.get(student) == null){
				classification.put(student, new ArrayList<QuestionDefinition>());
			}
			classification.get(student).add(q);
		}
		return classification;
	}

	private double getAvgAccurarcy(List<QuestionDefinition> list){
		if(list == null || list.size() == 0){
			return INVALID_AVG;
		}
		double count = 0;
		for(QuestionDefinition q : list){
			if(q.isAnsweredCorrectly()){
				count++;
			}
		}
		return count / list.size();
	}

	@Override
	public Map<Integer, Distribution> generateFirstResponseDistribution(
			List<QuestionDefinition> list) {
		Map<Integer, List<QuestionDefinition>> classification = groupByDifficultLevel(list);
		Map<Integer, Distribution> resultMap = new HashMap<>();
		
		for(Entry<Integer, List<QuestionDefinition>> entry : classification.entrySet()){
			List<QuestionDefinition> questionSet = entry.getValue();
			List<Integer> values = new ArrayList<>();
			for(QuestionDefinition q : questionSet){
				if(q.getAttempt_duration().size() > 0){
					values.add(q.getAttempt_duration().get(0));
				}
			}
			Distribution d = new Distribution(values);
			resultMap.put(entry.getKey(), d);
		}
		return resultMap;
	}

	@Override
	public Map<Integer, Distribution> generateFirstFaultResponseDistribution(
			List<QuestionDefinition> list) {
		Map<Integer, List<QuestionDefinition>> classification = groupByDifficultLevel(list);
		Map<Integer, Distribution> resultMap = new HashMap<>();
		
		for(Entry<Integer, List<QuestionDefinition>> entry : classification.entrySet()){
			List<QuestionDefinition> questionSet = entry.getValue();
			List<Integer> values = new ArrayList<>();
			for(QuestionDefinition q : questionSet){
				// attempts greater than 1 means first is incorrect attempt 
				if(q.getAttempts().size() > 1 && q.getAttempt_duration().size() > 0){
					values.add(q.getAttempt_duration().get(0));
				}
			}
			Distribution d = new Distribution(values);
			resultMap.put(entry.getKey(), d);
		}
		return resultMap;
	}
	
	private boolean isAdjacentKey(double answer, double attempt){
		return Math.abs(answer - attempt) == 1 ||
				Math.abs(answer - attempt) == 10;
	}

	@Override
	public Map<Integer, Distribution> generateFirstAttemptOnAdjacentKeys(
			List<QuestionDefinition> list) {
		Map<Integer, List<QuestionDefinition>> classification = groupByDifficultLevel(list);
		Map<Integer, Distribution> resultMap = new HashMap<>();
		
		for(Entry<Integer, List<QuestionDefinition>> entry : classification.entrySet()){
			List<QuestionDefinition> questionSet = entry.getValue();
			List<Integer> values = new ArrayList<>();
			for(QuestionDefinition q : questionSet){
				// attempts greater than 1 means first is incorrect attempt 
				if(q.getAttempts().size() > 1
						&& isAdjacentKey(q.getAttempts().get(0), q.getCorrect_answer())
						&& q.getAttempt_duration().size() > 0){
					values.add(q.getAttempt_duration().get(0));
				}
			}
			Distribution d = new Distribution(values);
			resultMap.put(entry.getKey(), d);
		}
		return resultMap;
	}

	@Override
	public Progression<QuestionDefinition> initProgression(int level) {
		List<QuestionDefinition> prog = new ArrayList<>();
		prog.add(qGenerator.getQuestion(level));
		return new Progression<QuestionDefinition>(prog);
	}


}
