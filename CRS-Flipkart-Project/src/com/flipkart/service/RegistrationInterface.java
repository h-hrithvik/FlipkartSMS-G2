package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.PaymentNotFoundException;

public interface RegistrationInterface {
	public boolean addCourse(String courseId, String studentId, List<Course> courseList) throws AddCourseException;
	
	public boolean dropCourse(String courseId, String studentId, List<Course> registeredCourseList) throws CourseNotDeletedException;
	
	public List<Course> viewCourses();
	
	public List<Course> viewRegisteredCourses(String studentId);
	
	public ReportCard viewReportCard(String studentId);
	
	public double payFee(String studentId) throws PaymentNotFoundException;
	
}
