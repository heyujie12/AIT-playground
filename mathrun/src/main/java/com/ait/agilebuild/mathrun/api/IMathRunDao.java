package com.ait.agilebuild.mathrun.api;

import java.util.List;

import com.ait.agilebuild.mathrun.model.Game;
import com.ait.agilebuild.mathrun.model.Student;
import com.ait.agilebuild.mathrun.model.Teacher;

public interface IMathRunDao {

	/**
	 * Returns a List of Game objects that are associated with given Student id.
	 * <p>
	 * This method always returns a reference to a List, whether or not the
	 * Student exists in database. When no game is found for the student or
	 * student id is not valid, returns an empty List where no elements in it
	 * 
	 * @param studentId
	 * @return games for which a specified Student has played
	 * @see		com.ait.agilebuild.mathrun.model.Student
	 */
	public List<Game> getGames(long studentId);
	
	public List<Teacher> getTeachers();
	
	public Student getStudentById(long id);

	public List<Student> getStudentsByClass(String studentClass);
	
}
