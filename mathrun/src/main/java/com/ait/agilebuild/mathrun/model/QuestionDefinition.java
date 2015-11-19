package com.ait.agilebuild.mathrun.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class QuestionDefinition {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private float first_value;
	private float second_value;
	private int operator;                                           //1->+, 2->-, 3->*, 4->/
	private String operatorCh;
	private int difficulty_level;
	private float correct_answer;
	private int remainder;                                          //only available for divisions
	
	@ElementCollection
	@CollectionTable(name="attempt", joinColumns=@JoinColumn(name="qd_id"))
	@Column(name="attempt_answer")
	private List<Float> attempts;
	
	@ElementCollection
	@CollectionTable(name="attempt_duration", joinColumns=@JoinColumn(name="qd_id"))
	@Column(name="attempt_time")
	private List<Integer> attempt_duration;							    //time taken each attempt
	
	private int time;                                               //how long does kid spend on each question

	@ManyToOne
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name = "game")
	private Game game;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getOperatorCh() {
		return operatorCh;
	}

	public void setOperatorCh(String operatorCh) {
		this.operatorCh = operatorCh;
	}

	public int getDifficulty_level() {
		return difficulty_level;
	}

	public void setDifficulty_level(int difficulty_level) {
		this.difficulty_level = difficulty_level;
	}

	public float getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(float correct_answer) {
		this.correct_answer = correct_answer;
	}

	public int getRemainder() {
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	public List<Float> getAttempts() {
		return attempts;
	}

	public void setAttempts(List<Float> attempts) {
		this.attempts = attempts;
	}

	public List<Integer> getAttempt_duration() {
		return attempt_duration;
	}

	public void setAttempt_duration(List<Integer> attempt_duration) {
		this.attempt_duration = attempt_duration;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public boolean isAnsweredCorrectly(){
		return correct_answer == attempts.get(attempts.size()-1);
	}

}
