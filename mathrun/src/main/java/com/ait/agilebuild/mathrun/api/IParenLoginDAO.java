package com.ait.agilebuild.mathrun.api;

import com.ait.agilebuild.mathrun.model.Student;

public interface IParenLoginDAO {
	
	public boolean checkParents(String name, String email);
	//public Student fetchChildinfo(String email);
}
