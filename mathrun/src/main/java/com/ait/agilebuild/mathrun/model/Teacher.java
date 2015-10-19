package com.ait.agilebuild.mathrun.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Teacher {
	@Id
	private String email;
	
	private String name;
	
	private String password;
}
