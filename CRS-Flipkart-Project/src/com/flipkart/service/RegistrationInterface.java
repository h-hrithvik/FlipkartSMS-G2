package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.*;

public interface RegistrationInterface {
	public boolean addCourse(String courseId, String studentId, List<Course> courseList);
	
	public boolean dropCourse(String courseId, String studentId, List<Course> registeredCourseList);
	
	public List<Course> viewCourses();
	
	public List<Course> viewRegisteredCourses(String studentId);
	
	public ReportCard viewReportCard(String studentId);
	
	public double payFee(String studentId);
	
}
