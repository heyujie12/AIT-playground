package com.ait.agilebuild.mathrun.impl;

import java.util.List;




import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ait.agilebuild.mathrun.api.IMathRunDao;
import com.ait.agilebuild.mathrun.model.Game;
import com.ait.agilebuild.mathrun.model.QuestionDefinition;
import com.ait.agilebuild.mathrun.model.Student;
import com.ait.agilebuild.mathrun.model.StudentReport;
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
	
	public Student getStudent(long id){
		return em.find(Student.class, id);
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

	@Override
	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentsByClass(String studentClass) {
		Query query = em.createQuery("SELECT s FROM Student s where s.className = :className");
		query.setParameter("className", studentClass);
		return query.getResultList();
	}

	@Override
	public List<Student> getAllStudents() {
		Query query = em.createQuery("SELECT s FROM Student s");
		return query.getResultList();
	}

	@Override
	public List<QuestionDefinition> getQuestionsByLevel(int level) {
		Query query = em.createQuery("SELECT q FROM Student QuestionDefinition q where q.difficulty_level = :difficulty_level");
		query.setParameter("className", level);
		return query.getResultList();
	}

}
