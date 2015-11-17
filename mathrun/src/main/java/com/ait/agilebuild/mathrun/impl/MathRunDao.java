package com.ait.agilebuild.mathrun.impl;

import java.util.List;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ait.agilebuild.mathrun.api.IMathRunDao;
import com.ait.agilebuild.mathrun.model.Game;
import com.ait.agilebuild.mathrun.model.Student;
import com.ait.agilebuild.mathrun.model.Teacher;

public class MathRunDao implements IMathRunDao {

	@Inject
	private EntityManager em;

	@Override
	public List<Game> getGames(long studentId) {
		Query query = em.createQuery("SELECT g FROM Game g where g.student.id = :studentId");
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}
	
	public Student addStudent(Student student){
		em.persist(student);
		
		return student;
	}
	
	public Student deleteStudent(Student student){
		
		em.remove(student);
		return student;
		
	}
	
	public Student updateStudent(Student student){
		return em.merge(student);
	}

	@Override
	public List<Teacher> getTeachers() {
		Query query = em.createQuery("SELECT t FROM Teacher t");
		return query.getResultList();
	}

}
