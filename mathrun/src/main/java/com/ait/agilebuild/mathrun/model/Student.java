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
	private long id;
	
	private String name;
	
	private String className;

	@ManyToOne
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name = "teacher")
	private Teacher teacher;

	@ManyToOne
	@Basic(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent")
	private Parent parent;
}
