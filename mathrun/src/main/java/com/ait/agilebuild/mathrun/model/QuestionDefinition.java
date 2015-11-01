package com.ait.agilebuild.mathrun.model;

public class QuestionDefinition {
	
	private float first_value;
	private float second_value;
	private int operator;                                            //1->+, 2->-, 3->*, 4->/
	private String difficulty_level;
	private float correct_answer;
	private int Remainder;                                           //only available for divisions
	
	
	private int attempt_times;                                            
	private float[] attempts;
	
	private int time;                                                //how long does kid spend on each question
	
	
	public float getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(float correct_answer) {
		this.correct_answer = correct_answer;
	}
	public float getFirst_value() {
		return first_value;
	}
	public void setFirst_value(float first_value) {
		this.first_value = first_value;
	}
	public float getSecond_value() {
		return second_value;
	}
	public void setSecond_value(float second_value) {
		this.second_value = second_value;
	}
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	public String getDifficulty_level() {
		return difficulty_level;
	}
	public void setDifficulty_level(String difficulty_level) {
		this.difficulty_level = difficulty_level;
	}
	
	public int getRemainder() {
		return Remainder;
	}
	public void setRemainder(int remainder) {
		Remainder = remainder;
	}
	
}
