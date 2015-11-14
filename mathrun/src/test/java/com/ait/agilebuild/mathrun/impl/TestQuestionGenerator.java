package com.ait.agilebuild.mathrun.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public class TestQuestionGenerator {

	@Test
	public void testGenratorDiff_1(){
		QuestionsGenerator QG = new QuestionsGenerator();
		QuestionDefinition QD = new QuestionDefinition();
		QD = QG.getQuestion(5);
		assertNotNull(QD);
		System.out.println(QD.getFirst_value()+" "+QD.getOperatorCh()+" "+QD.getSecond_value()+" = "+QD.getCorrect_answer() );
	}
}
