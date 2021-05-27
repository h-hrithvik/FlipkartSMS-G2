package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.bean.ReportCard;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitReachedException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.PaymentNotFoundException;
import com.flipkart.exception.StudentNotRegisteredException;

public class RegistrationOperation implements RegistrationInterface {

	private static volatile RegistrationOperation instance = null;
	private static Logger logger = Logger.getLogger(StudentDaoOperation.class);

	/**
	 * Default constructor
	 */
	private RegistrationOperation() {
	}

	/**
	 * Method to make Registration Operation Singleton
	 *
	 * @return
	 */
	public static RegistrationOperation getInstance() {
		if (instance == null) {
			synchronized (RegistrationOperation.class) {
				instance = new RegistrationOperation();
			}
		}
		return instance;
	}

	RegistrationDaoInterface registrationDaoInterface = RegistrationDaoOperation.getInstance();


	/**
	 * Method to add Course selected by student
	 *
	 * @param courseId id of course
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return boolean indicating if the course is added successfully
	 * @throws CourseNotFoundException
	 * @throws AddCourseException
	 * @throws CourseLimitReachedException
	 * @throws SQLException
	 */
	@Override
	public boolean addCourse(String courseId, String studentId, int semester) throws CourseNotFoundException,AddCourseException, CourseLimitReachedException, SQLException {

		try {
			if (registrationDaoInterface.numOfRegisteredCourses(studentId, semester) >= 6) {
				throw new CourseLimitReachedException(semester);
			}
			if (registrationDaoInterface.isRegistered(courseId, studentId, semester)) {
				throw new CourseAlreadyRegisteredException(courseId);
			}
			return registrationDaoInterface.addCourse(courseId, studentId, semester);
		}
		catch (SQLException e) {
			logger.error("");
		} catch(CourseLimitReachedException e) {
			logger.error("You cannot register for more than 6 courses.");
		} catch (CourseAlreadyRegisteredException e) {
			logger.error("");
		}
	
		return false;
		
	}


	/**
	 *  Method to drop Course selected by student
	 *
	 * @param courseId id of course
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return boolean indicating if the course is dropped successfully
	 * @throws CourseNotDeletedException
	 * @throws SQLException
	 */
	@Override
	public boolean dropCourse(String courseId, String studentId, int semester)
			throws CourseNotDeletedException, SQLException {
		try {
			if(!registrationDaoInterface.isRegistered(courseId, studentId, semester)) {
				throw new SQLException();
			}
		} catch (SQLException e) {
			//logger.error("");
		} 
		return registrationDaoInterface.removeCourse(courseId, studentId, semester);
	}


	/**
	 * Method to view the list of available courses
	 *
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return List of courses
	 * @throws SQLException
	 */
	@Override
	public List<Course> viewCourses(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		return registrationDaoInterface.viewCourses(studentId, semester);
	}


	/**
	 * Method to view the list of courses registered by the student
	 *
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return List of registered courses
	 * @throws SQLException
	 */
	@Override
	public List<Course> viewRegisteredCourses(String studentId, int semester) throws SQLException {
		return registrationDaoInterface.viewRegisteredCourses(studentId, semester);
	}


	/**
	 * Method to view report card for students
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return report card object
	 * @throws SQLException
	 */
	@Override
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException {
			try {
				return registrationDaoInterface.viewReportCard(studentId, semester);
			} catch (SQLException | PaymentNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}


	/**
	 * Method for Fee payment for selected courses
	 * @param payment payment object with payment details
	 * @return boolean for successful/unsuccessful payment
	 * @throws PaymentNotFoundException
	 * @throws SQLException
	 */
	@Override
	public boolean payFee(Payment payment) throws PaymentNotFoundException,SQLException {
		return registrationDaoInterface.payFee(payment);
	}


	/**
	 * Method to view the total fee
	 *
	 * @param studentId id of student
	 * @param semester semester for fee payment
	 * @return Payment object containing payment details
	 * @throws SQLException
	 */
	@Override
	public Payment viewFee(String studentId,int semester) throws SQLException{
		return registrationDaoInterface.viewFee(studentId, semester);
	}

}
