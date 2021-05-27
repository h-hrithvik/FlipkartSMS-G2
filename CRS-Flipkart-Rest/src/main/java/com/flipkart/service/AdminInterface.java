/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.ProfessorNotDeletedException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author arya_
 *
 */
public interface AdminInterface {

	/**
	 * Method to Delete Course from Course Catalog
	 * 
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException
	 */
	public void removeCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException;

	/**
	 * Method to add Course to Course Catalog
	 * 
	 * @param course : Course object storing details of a course
	 * @throws AddCourseException
	 */
	public void addCourse(Course course) throws AddCourseException;

	/**
	 * Method to approve a Student
	 * 
	 * @param studentId
	 * @throws StudentNotFoundForVerificationException
	 * @return Approval Status
	 */
	public boolean approveStudent(String studentId) throws StudentNotFoundForVerificationException;

	/**
	 * Method to add Professor to DB
	 * 
	 * @param professor : Professor Object storing details of a professor
	 * @throws ProfessorNotAddedException
	 * @throws UserAlreadyExistException
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserAlreadyExistException;

	/**
	 * Method to delete Professor from DB
	 * 
	 * @param professorId
	 * @throws ProfessorNotAddedException
	 * @throws ProfessorNotDeletedException 
	 */
	public void removeProfessor(String professorId) throws ProfessorNotAddedException, ProfessorNotDeletedException;

	/**
	 * Function to generate report
	 * @param semester
	 * @param userId
	 * @throws StudentNotRegisteredException
	 * @throws SQLException 
	 */
	void generateReport(String userId, int semester) throws StudentNotRegisteredException;

}
