package com.ait.agilebuild.mathrun.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ait.agilebuild.mathrun.api.IMachineLearning;
import com.ait.agilebuild.mathrun.api.IQuestionsGenerator;
import com.ait.agilebuild.mathrun.model.Distribution;
import com.ait.agilebuild.mathrun.model.Progression;
import com.ait.agilebuild.mathrun.model.QuestionDefinition;

@Stateless
public class MachineLearning implements IMachineLearning{
	private static final long QUESTION_TIME_SPAN = 8000;
	@Inject
	private IQuestionsGenerator qGenerator;

	@Override
	public QuestionDefinition produceNextQuestion(Progression<QuestionDefinition> p){
		if(p == null){
			throw new IllegalArgumentException("Progression can not be null");
		}
		if(p.size() == 0){
			throw new IllegalStateException("Progression size can not be zero");
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
			float finalAttemp = q.getAttempts()[q.getAttempts().length - 1];
			if(finalAttemp != q.getCorrect_answer()){
				// when question is answered incorrectly
				if(result > 0){
					result = 0;
				}
				result = -5;
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
		if(q.getAttempts().length == 1){
			if(q.getTime() < QUESTION_TIME_SPAN * 0.3){
				return 5;
			}else if(q.getTime() < QUESTION_TIME_SPAN * 0.7){
				return 4;
			}else if(q.getTime() < QUESTION_TIME_SPAN){
				return 2;
			}
		}else if(q.getAttempts().length > 1){
			if(q.getTime() < QUESTION_TIME_SPAN * 0.3){
				return 4;
			}else if(q.getTime() < QUESTION_TIME_SPAN * 0.7){
				return 2;
			}else if(q.getTime() < QUESTION_TIME_SPAN){
				return 1;
			}
		}
		return 0;
	}

	@Override
	public Map<Integer, Distribution> generateFirstResponseDistribution(
			List<QuestionDefinition> list) {
		Map<Integer, Distribution> resultMap = new HashMap<>();
		if(list == null || list.size() == 0){
			return resultMap;
		}
		return null;
	}

	@Override
	public Map<Integer, Distribution> generateFirstFaultResponseDistribution(
			List<QuestionDefinition> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Distribution> generateFirstAttemptOnAdjacentKeys(
			List<QuestionDefinition> list) {
		// TODO Auto-generated method stub
		return null;
	}


}
