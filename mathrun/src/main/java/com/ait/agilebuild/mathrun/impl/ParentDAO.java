package com.ait.agilebuild.mathrun.impl;

import java.util.List;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ait.agilebuild.mathrun.api.IParenLoginDAO;
import com.ait.agilebuild.mathrun.model.Student;


public class ParentDAO implements IParenLoginDAO{
	@Inject
	private EntityManager em;
	
	@Override
	public boolean checkParents(String username, String email){
		try{
			Query query = em.createQuery("select p.email from Parent p where p.name = '"+username+"'");
			for(int i =0;i<=query.getResultList().size();i++){
				if(query.getResultList().get(i).toString().equals(email)){
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Student fetchChildinfo(String email){
		try{
			Query query =em.createQuery("SELECT s FROM Student s where s.parent.email = :email");
			query.setParameter("email", email);
			List childsinfo = query.getResultList();
			Student stu = (Student)childsinfo.get(0);
			return stu;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
