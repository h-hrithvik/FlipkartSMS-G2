/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author hp
 *
 */
public class ProfessorOperation implements ProfessorInterface {

	@Override
	public List<Course> getCourses(String professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> viewStudents(String courseId) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addGrade(String studentId, String courseId, String grade)
			throws StudentNotRegisteredException, StudentNotFoundForVerificationException {
		// TODO Auto-generated method stub
		return false;
	}

}
