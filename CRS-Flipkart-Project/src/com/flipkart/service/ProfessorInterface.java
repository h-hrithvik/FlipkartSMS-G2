/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author hp
 *
 */
public interface ProfessorInterface {

	/**
	 * Function to get all the courses
	 * 
	 * @param professorId
	 * @return list of all the courses
	 */
	public List<Course> getCourses(String professorId);

	/**
	 * Function to get list of students registered for a course
	 * 
	 * @param professorId
	 * @param courseId
	 * @return list of registered students
	 * @throws CourseNotFoundException
	 */
	public List<EnrolledStudent> viewStudents(String professorId) ;

	/**
	 * Function to add grade for a student registered in a course
	 * 
	 * @param studentId
	 * @param courseId
	 * @param grade
	 * @return status if the grade is successfully registered or not
	 * @throws StudentNotFoundForVerificationException
	 * @throws StudentNotRegisteredException
	 */
	public boolean addGrade(String studentId, String courseId,int  semester, String grade)
			throws StudentNotRegisteredException, StudentNotFoundForVerificationException,GradeNotAddedException;

}
