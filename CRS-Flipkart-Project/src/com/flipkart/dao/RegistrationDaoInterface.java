/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;

/**
 * @author WIN 10
 *
 */
public interface RegistrationDaoInterface {

	/**
	 * Method to add course in database
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return boolean indicating if the course is added successfully
	 * @throws SQLException
	 */
	public boolean addCourse(String courseId, String studentId, List<Course> courseList) throws SQLException;

	/**
	 * Drop Course selected by student
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return boolean indicating if the course is dropped successfully
	 * @throws CourseNotFoundException
	 * @throws SQLException
	 */
	public boolean removeCourse(String courseId, String studentId, List<Course> registeredCourseList) throws SQLException;

	/**
	 * Method to get the list of courses available from course catalog
	 * 
	 * @param studentId
	 * @return list of Courses
	 * @throws SQLException
	 */
	public List<Course> viewCourses(String studentId, int semester) throws SQLException;

	/**
	 * Method to View list of Registered Courses
	 * 
	 * @param studentId
	 * @return list of Registered Courses
	 * @throws SQLException
	 */
	public List<Course> viewRegisteredCourses(String studentId, int semester) throws SQLException;

	/**
	 * Method to view grade card of the student
	 * 
	 * @param studentId
	 * @return Grade Card
	 * @throws SQLException
	 */
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException;

	/**
	 * Method to retrieve fee for the selected courses from the database and
	 * calculate total fee
	 * 
	 * @param studentId
	 * @return Fee Student has to pay
	 * @throws SQLException
	 */
	public double payFee(String studentId, int semester) throws SQLException;

}
