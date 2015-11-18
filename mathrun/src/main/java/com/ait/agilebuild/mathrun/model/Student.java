package com.ait.agilebuild.mathrun.model;

import java.util.ArrayList;
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

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String className;

	@ManyToOne
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name = "teacher")
	private Teacher teacher;
	private long idStudent;

	private String age;
	private String year;


	@ManyToOne
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent")
	private Parent parent;

	@OneToMany(mappedBy = "student")
	private List<Game> games;

	public Student() {
	}

	public Student(int idStudent, String name, String age, String year) {

		this.idStudent = idStudent;
		this.name = name;
		this.age = age;
		this.year = year;
	}

	public long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(long idStudent) {
		this.idStudent = idStudent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public List<QuestionDefinition> getAllQuestions(){
		List<QuestionDefinition> questions = new ArrayList<>();
		if(games != null){
			for(Game g : games){
				questions.addAll(g.getQuestions());
			}
		}
		return questions;
	}

}
