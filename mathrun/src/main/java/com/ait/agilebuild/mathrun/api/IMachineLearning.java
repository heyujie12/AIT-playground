package com.ait.agilebuild.mathrun.api;

import java.util.List;
import java.util.Map;

import com.ait.agilebuild.mathrun.model.Distribution;
import com.ait.agilebuild.mathrun.model.Progression;
import com.ait.agilebuild.mathrun.model.QuestionDefinition;

public interface IMachineLearning {
	
	/**
	 * Returns next question based on student progression in a game
	 * @param Progression<QuestionDefinition>
	 * @return QuestionDefinition object
	 */
	public QuestionDefinition produceNextQuestion(Progression<QuestionDefinition> p);
	
	/**
	 *	Returns a map object in which question difficulty level is the key
	 *	and Distribution object is the value. 
	 *	Distribution looks after user first response time and provide statistics for each
	 *	difficulty level
	 *	@param List<QuestionDefinition>
	 *	@return Map<Integer, Distribution>
	 */
	public Map<Integer, Distribution> generateFirstResponseDistribution(List<QuestionDefinition> list);
	

	/**
	 *	Returns a map object in which question difficulty level is the key
	 *	and Distribution object is the value. 
	 *	Distribution looks after user first fault response time 
	 *	and provide statistics for each difficulty level
	 *	Questions being answered correctly are not considered 
	 *	@param List<QuestionDefinition>
	 *	@return Map<Integer, Distribution>
	 */
	public Map<Integer, Distribution> generateFirstFaultResponseDistribution(List<QuestionDefinition> list);

	/**
	 *	Returns a map object in which question difficulty level is the key
	 *	and Distribution object is the value. 
	 *	Distribution looks after user first fault response time 
	 *	and provide statistics for each difficulty level
	 *	Questions being answered correctly are not considered 
	 *	Only wrong attempt hitting on adjacent keys to correct key is considered
	 *	<p>
	 *	This is used to find out normal response behaviors of misclick
	 *	</p>
	 *	@param List<QuestionDefinition>
	 *	@return Map<Integer, Distribution>
	 */
	public Map<Integer, Distribution> generateFirstAttemptOnAdjacentKeys(List<QuestionDefinition> list);
}
