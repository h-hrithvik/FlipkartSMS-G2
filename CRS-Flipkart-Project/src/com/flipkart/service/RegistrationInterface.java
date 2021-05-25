package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.*;

public interface RegistrationInterface {
	/**
	 * Function to add course to registered course list
	 * 
	 * @param courseId
	 * @param studentId
	 * @param courseList
	 * @return add course success/failure
	 */
	public boolean addCourse(String courseId, String studentId, List<Course> courseList);

	/**
	 * Function to remove course to registered course list
	 * 
	 * @param courseId
	 * @param studentId
	 * @param registeredCourseList
	 * @return remove course success/failure
	 */
	public boolean dropCourse(String courseId, String studentId, List<Course> registeredCourseList);

	/**
	 * Function to view all courses available
	 * 
	 * @return list of all courses
	 */
	public List<Course> viewCourses();

	/**
	 * Function to view all registered courses
	 * 
	 * @param studentId
	 * @return registered courses list
	 */
	public List<Course> viewRegisteredCourses(String studentId);

	/**
	 * Function to view the report card for semester
	 * 
	 * @param studentId
	 * @return report card
	 */
	public ReportCard viewReportCard(String studentId);

	/**
	 * Function to pay registration fee
	 * 
	 * @param studentId
	 * @return amount paid
	 */
	public double payFee(String studentId);

}
