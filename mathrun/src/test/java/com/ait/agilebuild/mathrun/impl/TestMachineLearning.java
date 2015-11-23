package com.ait.agilebuild.mathrun.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ait.agilebuild.mathrun.api.IMachineLearning;
import com.ait.agilebuild.mathrun.api.IMathRunDao;
import com.ait.agilebuild.mathrun.api.IQuestionsGenerator;
import com.ait.agilebuild.mathrun.model.Progression;
import com.ait.agilebuild.mathrun.model.QuestionDefinition;
import com.ait.agilebuild.mathrun.model.Student;

public class TestMachineLearning {
	
	private IMachineLearning ml;
	
	private IQuestionsGenerator qGenerator;

	@BeforeMethod
	public void setUp() throws Exception {
		qGenerator = new QuestionsGenerator();
		IMathRunDao mathrunDao = Mockito.mock(IMathRunDao.class);
		Student s = Mockito.mock(Student.class);
		List<QuestionDefinition> studentQuestions = new ArrayList<>();
		studentQuestions = generateMockQuestions(1, 10);
		studentQuestions.addAll(generateMockQuestions(2, 10));
		Mockito.when(s.getAllQuestions()).thenReturn(studentQuestions);
		
		Mockito.when(mathrunDao.getQuestionsByLevel(1)).thenReturn(generateMockQuestions(1, 1000));
		Mockito.when(mathrunDao.getQuestionsByLevel(2)).thenReturn(generateMockQuestions(2, 1000));
		Mockito.when(mathrunDao.getStudentById(Mockito.anyLong())).thenReturn(s);
		ml = new MachineLearning();
		Whitebox.setInternalState(ml, "qGenerator", qGenerator);
		Whitebox.setInternalState(ml, "mathrunDao", mathrunDao);
	}
	
	private List<QuestionDefinition> generateMockQuestions(int level, int count) {
		System.out.println("Mock questions generation is called with level = " + level + ", count = " + count);
		List<QuestionDefinition> questions = new ArrayList<>();
		for(int i=0; i<count; i++){
			QuestionDefinition q = qGenerator.getQuestion(level);
			List<Float> attempts = new ArrayList<>();
			if(Math.random() <= 0.2){
				attempts.add(0f);
			}else{
				attempts.add(q.getCorrect_answer());
			}
			q.setAttempts(attempts);
			questions.add(q);
		}
		return questions;
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testProduceNextQuestionWithNull() {
		ml.produceNextQuestion(null);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testProduceNextQuestionWithEmptyQuestion() {
		ml.produceNextQuestion(new Progression<QuestionDefinition>(new ArrayList<QuestionDefinition>()));
	}
	
	@Test
	public void testProduceNextQuestion_OneCorrectQuestion(){
		final int initialLevel = 5;
		List<QuestionDefinition> questionSet = new ArrayList<>();
		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
		
		questionSet.add(getNormalResponseQuestion(q));
		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
		QuestionDefinition nextQ = ml.produceNextQuestion(p);
		assertTrue("Is next question level same as that of the last one:  ", nextQ.getDifficulty_level() == initialLevel);
	}
	
	@Test
	public void testProduceNextQuestion_TwoCorrectQuestions(){
		final int initialLevel = 5;
		List<QuestionDefinition> questionSet = new ArrayList<>();
		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
		
		questionSet.add(getNormalResponseQuestion(q));
		questionSet.add(getNormalResponseQuestion(q));
		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
		QuestionDefinition nextQ = ml.produceNextQuestion(p);
		assertTrue("Is next question level same as that of the last one:  ", nextQ.getDifficulty_level() == initialLevel);
	}
	
	@Test
	public void testProduceNextQuestion_ThreeCorrectQuestions(){
		final int initialLevel = 5;
		List<QuestionDefinition> questionSet = new ArrayList<>();
		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
		
		questionSet.add(getNormalResponseQuestion(q));
		questionSet.add(getNormalResponseQuestion(q));
		questionSet.add(getNormalResponseQuestion(q));
		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
		QuestionDefinition nextQ = ml.produceNextQuestion(p);
		assertTrue("Is next question level same as that of the last one:  ", nextQ.getDifficulty_level() == initialLevel);
	}
	
	@Test
	public void testProduceNextQuestion_FourCorrectQuestions(){
		final int initialLevel = 5;
		List<QuestionDefinition> questionSet = new ArrayList<>();
		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
		
		questionSet.add(getNormalResponseQuestion(q));
		questionSet.add(getNormalResponseQuestion(q));
		questionSet.add(getNormalResponseQuestion(q));
		questionSet.add(getNormalResponseQuestion(q));
		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
		QuestionDefinition nextQ = ml.produceNextQuestion(p);
		assertTrue("Is next question level same as that of the last one:  ", nextQ.getDifficulty_level() == initialLevel);
	}
	
	@Test
	public void testProduceNextQuestion_FiveCorrectQuestions(){
		final int initialLevel = 5;
		List<QuestionDefinition> questionSet = new ArrayList<>();
		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
		
		questionSet.add(getNormalResponseQuestion(q));
		questionSet.add(getNormalResponseQuestion(q));
		questionSet.add(getNormalResponseQuestion(q));
		questionSet.add(getNormalResponseQuestion(q));
		questionSet.add(getNormalResponseQuestion(q));
		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
		QuestionDefinition nextQ = ml.produceNextQuestion(p);
		assertTrue("Is next question level one more than that of the last one:  ", nextQ.getDifficulty_level() == initialLevel + 1);
	}
	
	@Test
	public void testProduceNextQuestion_OneWrongQuestion(){
		final int initialLevel = 5;
		List<QuestionDefinition> questionSet = new ArrayList<>();
		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
		
		questionSet.add(getNormalResponseQuestionWithWrongAttempts(q));
		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
		QuestionDefinition nextQ = ml.produceNextQuestion(p);
		assertTrue("Is next question level same as that of the last one:  ", nextQ.getDifficulty_level() == initialLevel);
	}
	
	@Test
	public void testProduceNextQuestion_TwoWrongQuestions(){
		final int initialLevel = 5;
		List<QuestionDefinition> questionSet = new ArrayList<>();
		QuestionDefinition q = qGenerator.getQuestion(initialLevel);

		questionSet.add(getNormalResponseQuestionWithWrongAttempts(q));
		questionSet.add(getNormalResponseQuestionWithWrongAttempts(q));
		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
		QuestionDefinition nextQ = ml.produceNextQuestion(p);
		assertTrue("Is next question level one less than that of the last one:  ", nextQ.getDifficulty_level() == initialLevel - 1);
	}
	
	@Test
	public void testProduceNextQuestion_CorrectWithWrongAttempts(){
		final int initialLevel = 5;
		List<QuestionDefinition> questionSet = new ArrayList<>();
		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
		for(int i=0; i<9; i++){
			questionSet.add(getNormalResponseQuestionCorrectWithWrongAttempts(q));
		}
		Progression<QuestionDefinition> p9= new Progression<QuestionDefinition>(questionSet);
		QuestionDefinition nextQ10 = ml.produceNextQuestion(p9);
		assertTrue("Is next question level same as that of the last one:  ", nextQ10.getDifficulty_level() == initialLevel);
		
		questionSet.add(getNormalResponseQuestionCorrectWithWrongAttempts(q));
		Progression<QuestionDefinition> p10= new Progression<QuestionDefinition>(questionSet);
		QuestionDefinition nextQ11 = ml.produceNextQuestion(p10);
		assertTrue("Is next question level one more than that of the last one:  ", nextQ11.getDifficulty_level() == initialLevel + 1);
	}

	private QuestionDefinition getNormalResponseQuestion(QuestionDefinition q){
		final int time = (int) (MachineLearning.QUESTION_TIME_SPAN * 0.9);
		List<Float> attempts = new ArrayList<>();
		attempts.add(q.getCorrect_answer());
		q.setAttempts(attempts);
		List<Integer> attemptDurations = new ArrayList<>();
		attemptDurations.add(time);
		q.setAttempt_duration(attemptDurations);
		q.setTime(time);
		return q;
	}
	
	private QuestionDefinition getNormalResponseQuestionWithWrongAttempts(QuestionDefinition q){
		final int time = (int) (MachineLearning.QUESTION_TIME_SPAN * 0.9);

		List<Float> attempts = new ArrayList<>();
		attempts.add(q.getCorrect_answer() + 1);
		q.setAttempts(attempts);
		List<Integer> attemptDurations = new ArrayList<>();
		attemptDurations.add(time);
		q.setAttempt_duration(attemptDurations);
		q.setTime(time);
		return q;
	}
	
	private QuestionDefinition getNormalResponseQuestionCorrectWithWrongAttempts(QuestionDefinition q){
		final int time = (int) (MachineLearning.QUESTION_TIME_SPAN * 0.9);
		final int f_time = (int) (time * Math.random());

		List<Float> attempts = new ArrayList<>();
		attempts.add(q.getCorrect_answer() + 1);
		attempts.add(q.getCorrect_answer());
		q.setAttempts(attempts);
		List<Integer> attemptDurations = new ArrayList<>();
		attemptDurations.add(time);
		q.setAttempt_duration(attemptDurations);
		
		q.setTime(time);
		return q;
	}
	
//	@Test
//	public void testGenerateLevelProficiency(){
//		Map<Integer, Double> map = ml.generateLevelProficiency(1l);
//		for(Entry<Integer, Double> entry : map.entrySet()){
//			System.out.println("Key: " + entry.getKey() + ", Value" + entry.getValue());
//		}
//	}
}
