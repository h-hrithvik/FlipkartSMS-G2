package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.PaymentNotFoundException;

public interface RegistrationInterface {
	/**
	 *
	 * @param courseId
	 * @param studentId
	 * @param courseList
	 * @return true/false for successful/unsuccessful operation of adding a course.
	 * @throws AddCourseException
	 */
	public boolean addCourse(String courseId, String studentId, List<Course> courseList) throws AddCourseException;

	/**
	 *
	 * @param courseId
	 * @param studentId
	 * @param registeredCourseList
	 * @return true/false for successful/unsuccessful operation of dropping a
	 *         course.
	 * @throws CourseNotDeletedException
	 */
	public boolean dropCourse(String courseId, String studentId, List<Course> registeredCourseList)
			throws CourseNotDeletedException;

	/**
	 *
	 * @return list of courses available
	 */
	public List<Course> viewCourses();

	/**
	 *
	 * @param studentId
	 * @return list of registered courses by a student.
	 */
	public List<Course> viewRegisteredCourses(String studentId);

	/**
	 *
	 * @param studentId
	 * @return report card of the student as an object of class ReportCard
	 */
	public ReportCard viewReportCard(String studentId);

	/**
	 *
	 * @param studentId
	 * @return total fees paid
	 * @throws PaymentNotFoundException on unsuccessful payment
	 */
	public double payFee(String studentId) throws PaymentNotFoundException;

}
