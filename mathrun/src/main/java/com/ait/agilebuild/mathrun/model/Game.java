package com.ait.agilebuild.mathrun.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name = "student")
	private Student student;
	
	@OneToMany(mappedBy="game")
	private List<QuestionDefinition> questions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<QuestionDefinition> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDefinition> questions) {
		this.questions = questions;
	}
	
}
