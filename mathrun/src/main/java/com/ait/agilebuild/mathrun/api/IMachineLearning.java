package com.ait.agilebuild.mathrun.api;

import com.ait.agilebuild.mathrun.model.Progression;
import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public interface IMachineLearning {
	
	/**
	 * 
	 * @param Progression
	 * @return
	 */
//	public <T> T produceNextLevel(Progression<T> p);

	public QuestionDefinition produceNextQuestion(Progression<QuestionDefinition> p);
}
