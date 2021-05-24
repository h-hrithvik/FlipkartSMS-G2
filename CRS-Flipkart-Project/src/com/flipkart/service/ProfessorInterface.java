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
	
	public List<Course> getCourses(String professorId);
	
	public List<Student> viewStudents(String professorId);
	
	public boolean addGrade(String studentId, String courseId , String grade);
	
	
}
