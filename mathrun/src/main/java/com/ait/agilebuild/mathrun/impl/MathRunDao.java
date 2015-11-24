package com.ait.agilebuild.mathrun.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ait.agilebuild.mathrun.api.IMathRunDao;
import com.ait.agilebuild.mathrun.model.Game;
import com.ait.agilebuild.mathrun.model.Student;

public class MathRunDao implements IMathRunDao {

	@Inject
	private EntityManager em;

	@Override
	public List<Game> getGames(long studentId) {
		Query query = em.createQuery("SELECT g FROM Game g where g.student.id = :studentId");
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}
	
	public List<Student> getStudents(){
		Query query = em.createQuery("SELECT s FROM Student s");
		System.out.println(((Student)query.getResultList().get(0)).getId());
		return query.getResultList();
	}

}
