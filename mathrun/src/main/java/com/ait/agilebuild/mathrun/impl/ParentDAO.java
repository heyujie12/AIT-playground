package com.ait.agilebuild.mathrun.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ait.agilebuild.mathrun.api.IParenLoginDAO;


public class ParentDAO implements IParenLoginDAO{
	@Inject
	private EntityManager em;
	
	@Override
	public boolean checkParents(String username, String email){
		try{
			Query query = em.createQuery("select p.email from Parent p where p.name = '"+username+"'");
//			query.setParameter("username", username);
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
}
