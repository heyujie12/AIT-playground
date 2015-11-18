package com.ait.agilebuild.mathrun.impl;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ait.agilebuild.mathrun.api.IMachineLearning;
import com.ait.agilebuild.mathrun.model.Progression;
import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public class TestMachineLearning {
	
	private IMachineLearning ml;
	
	@Before
	public void setUp() throws Exception {
		ml = new MachineLearning();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduceNextQuestionWithNull() {
		ml.produceNextQuestion(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduceNextQuestionWithEmptyQuestion() {
		ml.produceNextQuestion(new Progression<QuestionDefinition>(new ArrayList<QuestionDefinition>()));
	}
}
