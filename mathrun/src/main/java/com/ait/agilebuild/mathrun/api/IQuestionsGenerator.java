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
	
	public void create_2ndClassBeginner();
	public void create_2ndClassMedium();
	public void create_2ndClassAdvanced();
	
	public void create_3rdClassBeginner();
	public void create_3rdClassMedium();
	public void create_3rdClassAdvanced();
	
	public void create_4thClassBeginner();
	public void create_4thClassMedium();
	public void create_4thClassAdvanced();
	
	public void create_5thClassBeginner();
	public void create_5thClassMedium();
	public void create_5thClassAdvanced();

	public QuestionDefinition getQuestion();
}
