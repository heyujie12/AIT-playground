package com.ait.agilebuild.mathrun.model;

import java.util.Set;

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
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idStudent;
	
	private String name;
	
	
	private String age;
	private String year;
	public long getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public Student (int idStudent,String name,String age,String year){
		
		this.idStudent = idStudent;
		this.name = name;
		this.age = age;
		this.year = year;
	}
	
	
	@ManyToOne
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name = "teacher")
	private Teacher teacher;

	@ManyToOne
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent")
	private Parent parent;
}
