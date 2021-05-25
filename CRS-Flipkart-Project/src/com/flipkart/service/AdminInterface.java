/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.exception.AddCourseException;

/**
 * @author arya_
 *
 */
public interface AdminInterface {

	/**
	 * Function to remove a course
	 * 
	 * @param courseId
	 */
	public void removeCourse(String courseId);

	/**
	 * Function to add a course
	 * 
	 * @param course
	 */
	public void addCourse(Course course) throws AddCourseException;

	/**
	 * Function to approve student
	 * 
	 * @param studentId
	 * @return status whether student is approved or not
	 */
	public boolean approveStudent(String studentId);

	/**
	 * Function to add professor
	 * 
	 * @param professor
	 */
	public void addProfessor(Professor professor);

	/**
	 * Function to remove professor
	 * 
	 * @param prefessorId
	 */
	public void removeProfessor(String prefessorId);

	/**
	 * Function to generate report
	 * 
	 * @param reportCard
	 */
	public void generateReport(ReportCard reportCard);
}
