/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

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
	 */
	public List<Student> viewStudents(String courseId);

	/**
	 * Function to add grade for a student registered in a course
	 * 
	 * @param studentId
	 * @param courseId
	 * @param grade
	 * @return status if the grade is successfully registered or not
	 */
	public boolean addGrade(String studentId, String courseId, String grade);

}
