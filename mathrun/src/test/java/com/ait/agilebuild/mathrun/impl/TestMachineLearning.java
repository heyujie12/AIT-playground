//package com.ait.agilebuild.mathrun.impl;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.testng.annotations.Test;
//import org.mockito.internal.util.reflection.Whitebox;
//import org.testng.annotations.BeforeMethod;
//import org.junit.Test;
//import org.mockito.internal.util.reflection.Whitebox;
//
//import com.ait.agilebuild.mathrun.api.IMachineLearning;
//import com.ait.agilebuild.mathrun.api.IQuestionsGenerator;
//import com.ait.agilebuild.mathrun.model.Progression;
//import com.ait.agilebuild.mathrun.model.QuestionDefinition;
//
//public class TestMachineLearning {
//	
//	private IMachineLearning ml;
//	
//	private IQuestionsGenerator qGenerator;
//
//	@BeforeMethod
//	public void setUp() throws Exception {
//		ml = new MachineLearning();
//		qGenerator = new QuestionsGenerator();
//		Whitebox.setInternalState(ml, "qGenerator", qGenerator);
//	}
//	
//	@Test(expectedExceptions = IllegalArgumentException.class)
//	public void testProduceNextQuestionWithNull() {
//		ml.produceNextQuestion(null);
//	}
//	
//	@Test(expectedExceptions = IllegalArgumentException.class)
//	public void testProduceNextQuestionWithEmptyQuestion() {
//		ml.produceNextQuestion(new Progression<QuestionDefinition>(new ArrayList<QuestionDefinition>()));
//	}
//	
//	@Test
//	public void testProduceNextQuestion_OneCorrectQuestion(){
//		final int initialLevel = 5;
//		List<QuestionDefinition> questionSet = new ArrayList<>();
//		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
//		
//		questionSet.add(getNormalResponseQuestion(q));
//		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
//		QuestionDefinition nextQ = ml.produceNextQuestion(p);
//		assertTrue("Is next question level same as that of the last one:  ", nextQ.getDifficulty_level() == initialLevel);
//	}
//	
//	@Test
//	public void testProduceNextQuestion_TwoCorrectQuestions(){
//		final int initialLevel = 5;
//		List<QuestionDefinition> questionSet = new ArrayList<>();
//		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
//		
//		questionSet.add(getNormalResponseQuestion(q));
//		questionSet.add(getNormalResponseQuestion(q));
//		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
//		QuestionDefinition nextQ = ml.produceNextQuestion(p);
//		assertTrue("Is next question level same as that of the last one:  ", nextQ.getDifficulty_level() == initialLevel);
//	}
//	
//	@Test
//	public void testProduceNextQuestion_ThreeCorrectQuestions(){
//		final int initialLevel = 5;
//		List<QuestionDefinition> questionSet = new ArrayList<>();
//		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
//		
//		questionSet.add(getNormalResponseQuestion(q));
//		questionSet.add(getNormalResponseQuestion(q));
//		questionSet.add(getNormalResponseQuestion(q));
//		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
//		QuestionDefinition nextQ = ml.produceNextQuestion(p);
//		assertTrue("Is next question level same as that of the last one:  ", nextQ.getDifficulty_level() == initialLevel);
//	}
//	
//	@Test
//	public void testProduceNextQuestion_FourCorrectQuestions(){
//		final int initialLevel = 5;
//		List<QuestionDefinition> questionSet = new ArrayList<>();
//		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
//		
//		questionSet.add(getNormalResponseQuestion(q));
//		questionSet.add(getNormalResponseQuestion(q));
//		questionSet.add(getNormalResponseQuestion(q));
//		questionSet.add(getNormalResponseQuestion(q));
//		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
//		QuestionDefinition nextQ = ml.produceNextQuestion(p);
//		assertTrue("Is next question level same as that of the last one:  ", nextQ.getDifficulty_level() == initialLevel);
//	}
//	
//	@Test
//	public void testProduceNextQuestion_FiveCorrectQuestions(){
//		final int initialLevel = 5;
//		List<QuestionDefinition> questionSet = new ArrayList<>();
//		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
//		
//		questionSet.add(getNormalResponseQuestion(q));
//		questionSet.add(getNormalResponseQuestion(q));
//		questionSet.add(getNormalResponseQuestion(q));
//		questionSet.add(getNormalResponseQuestion(q));
//		questionSet.add(getNormalResponseQuestion(q));
//		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
//		QuestionDefinition nextQ = ml.produceNextQuestion(p);
//		assertTrue("Is next question level one more than that of the last one:  ", nextQ.getDifficulty_level() == initialLevel + 1);
//	}
//	
//	@Test
//	public void testProduceNextQuestion_OneWrongQuestion(){
//		final int initialLevel = 5;
//		List<QuestionDefinition> questionSet = new ArrayList<>();
//		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
//		
//		questionSet.add(getNormalResponseQuestionWithWrongAttempts(q));
//		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
//		QuestionDefinition nextQ = ml.produceNextQuestion(p);
//		assertTrue("Is next question level same as that of the last one:  ", nextQ.getDifficulty_level() == initialLevel);
//	}
//	
//	@Test
//	public void testProduceNextQuestion_TwoWrongQuestions(){
//		final int initialLevel = 5;
//		List<QuestionDefinition> questionSet = new ArrayList<>();
//		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
//
//		questionSet.add(getNormalResponseQuestionWithWrongAttempts(q));
//		questionSet.add(getNormalResponseQuestionWithWrongAttempts(q));
//		Progression<QuestionDefinition> p = new Progression<QuestionDefinition>(questionSet);
//		QuestionDefinition nextQ = ml.produceNextQuestion(p);
//		assertTrue("Is next question level one less than that of the last one:  ", nextQ.getDifficulty_level() == initialLevel - 1);
//	}
//	
//	@Test
//	public void testProduceNextQuestion_CorrectWithWrongAttempts(){
//		final int initialLevel = 5;
//		List<QuestionDefinition> questionSet = new ArrayList<>();
//		QuestionDefinition q = qGenerator.getQuestion(initialLevel);
//		for(int i=0; i<9; i++){
//			questionSet.add(getNormalResponseQuestionCorrectWithWrongAttempts(q));
//		}
//		Progression<QuestionDefinition> p9= new Progression<QuestionDefinition>(questionSet);
//		QuestionDefinition nextQ10 = ml.produceNextQuestion(p9);
//		assertTrue("Is next question level same as that of the last one:  ", nextQ10.getDifficulty_level() == initialLevel);
//		
//		questionSet.add(getNormalResponseQuestionCorrectWithWrongAttempts(q));
//		Progression<QuestionDefinition> p10= new Progression<QuestionDefinition>(questionSet);
//		QuestionDefinition nextQ11 = ml.produceNextQuestion(p10);
//		assertTrue("Is next question level one more than that of the last one:  ", nextQ11.getDifficulty_level() == initialLevel + 1);
//	}
//	
//	private QuestionDefinition getNormalResponseQuestion(QuestionDefinition q){
//		final int time = (int) (MachineLearning.QUESTION_TIME_SPAN * 0.9);
//		q.setAttempts(new float[]{q.getCorrect_answer()});
//		q.setAttempt_duration(new int[]{time});
//		q.setTime(time);
//		return q;
//	}
//	
//	private QuestionDefinition getNormalResponseQuestionWithWrongAttempts(QuestionDefinition q){
//		final int time = (int) (MachineLearning.QUESTION_TIME_SPAN * 0.9);
//		q.setAttempts(new float[]{q.getCorrect_answer() + 1});
//		q.setAttempt_duration(new int[]{time});
//		q.setTime(time);
//		return q;
//	}
//	
//	private QuestionDefinition getNormalResponseQuestionCorrectWithWrongAttempts(QuestionDefinition q){
//		final int time = (int) (MachineLearning.QUESTION_TIME_SPAN * 0.9);
//		final int f_time = (int) (time * Math.random());
//		q.setAttempts(new float[]{q.getCorrect_answer() + 1, q.getCorrect_answer()});
//		q.setAttempt_duration(new int[]{time});
//		q.setTime(time);
//		return q;
//	}
//}
