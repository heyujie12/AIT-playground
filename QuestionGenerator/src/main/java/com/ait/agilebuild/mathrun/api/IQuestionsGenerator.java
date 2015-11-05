package com.ait.agilebuild.mathrun.api;

import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public interface IQuestionsGenerator {
	
	/**
	 * Returns a question that is suitable for the user.
	 * 
	 * @return  a question for specific difficulty 
	 * @see		com.ait.agilebuild.mathrun.model.QuestionDefinition
	 * @see		com.ait.agilebuild.mathrun.model.QuestionGenerator
	 */


	public QuestionDefinition getQuestion(int difficulty_level);
}
