package com.ait.agilebuild.mathrun.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Parent {

	@Id
	private String email;
	
	private String name;
	
	private String password;

}
