/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.PaymentNotFoundException;
import com.flipkart.bean.Payment;
import com.flipkart.utils.DBUtils;

/**
 *
 * @author JEDI-03
 * Class to implement Registration Dao Operations
 * This class communicates with the database.
 *
 */

public class RegistrationDaoOperation implements RegistrationDaoInterface {

	private static volatile RegistrationDaoOperation instance=null;
	private static Logger logger = Logger.getLogger(RegistrationDaoOperation.class);
	private PreparedStatement stmt = null;

	/**
	 * Default Constructor
	 */
	private RegistrationDaoOperation()
	{}

	/**
	 * Method to make RegistrationDaoOperation Singleton
	 * @return
	 */
	public static RegistrationDaoOperation getInstance()
	{
		if(instance==null)
		{
			synchronized(RegistrationDaoOperation.class){
				instance=new RegistrationDaoOperation();
			}
		}
		return instance;
	}

	/**
	 * Number of registered courses for a student
	 *
	 * @param studentId id of the student
	 * @param semester semester number of the student
	 * @return Number of registered courses for a student
	 * @throws SQLException
	 */
	@Override
	public int numOfRegisteredCourses(String studentId, int semester) throws SQLException{
		
		Connection conn = DBUtils.getConnection();
		
		int count = 0;
		try {

			stmt = conn.prepareStatement(SQLQueriesConstants.NUMBER_OF_REGISTERED_COURSES);
			stmt.setString(1, studentId);
			stmt.setInt(2,  semester);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count++;
			}
			return count;

		}
//		catch (SQLException e) 
//		{
//
//			logger.error(e.getMessage());
//
//		} 
		catch (Exception e)
		{
			
			logger.error("");
		}
		
		return count;
	}


	/**
	 * Method to add course in database
	 * @param courseId id of the course
	 * @param studentId id of the student
	 * @return boolean indicating if the course is added successfully
	 * @throws SQLException
	 */
	@Override
	public boolean addCourse(String courseId, String studentId, int semester) throws SQLException {

		Connection conn = DBUtils.getConnection();

		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.ADD_COURSE);
			stmt.setString(1, studentId);
			stmt.setString(2, courseId);
			stmt.setInt(3, semester);
			stmt.setString(4, null);

			stmt.executeUpdate();
			stmt = conn.prepareStatement(SQLQueriesConstants.DECREMENT_COURSE_SEATS);
			stmt.setString(1, courseId);
			stmt.executeUpdate();

			return true;
		} catch (SQLException e) {
			logger.error("");
		} 
		return false;
	}

	/**
	 * Method checks if the student is registered for that course
	 * @param courseCode code of the course
	 * @param studentId id of the student
	 * @return Students registration status
	 * @throws SQLException
	 */
	@Override
	public boolean isRegistered(String courseCode, String studentId, int semester) throws SQLException{
		
		Connection conn = DBUtils.getConnection();
		
		boolean check = false;
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstants.IS_REGISTERED);
			stmt.setString(1, courseCode);
			stmt.setString(2, studentId);
			stmt.setInt(3, semester);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				check = true;
			}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		
		
		return check;
		
	}

	/**
	 * Drop Course selected by student
	 * @param courseId id for selected course
	 * @param studentId id of the logged in student
	 * @return status of drop course operation
	 * @throws SQLException
	 */
	@Override
	public boolean removeCourse(String courseId, String studentId, int semester) throws SQLException {
		Connection conn = DBUtils.getConnection();

		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.DROP_COURSE_QUERY);
			stmt.setString(1, courseId);
			stmt.setString(2, studentId);
			stmt.setInt(3, semester);
			int out = stmt.executeUpdate();
			
			if(out <= 0) {
				logger.error("No such course exists.");
				return false;
			}
			stmt = conn.prepareStatement(SQLQueriesConstants.INCREMENT_SEAT_QUERY);
			stmt.setString(1, courseId);
			stmt.execute();

			stmt.close();

			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 

		return true;
	}


	/**
	 * Method to get the list of courses available from course catalog
	 * @param studentId id of the student
	 * @param semester semester of the student
	 * @return list of courses
	 * @throws SQLException
	 */
	@Override
	public List<Course> viewCourses(String studentId, int semester) throws SQLException {
		List<Course> availableCourseList = new ArrayList<>();
		Connection conn = DBUtils.getConnection();

		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_AVAILABLE_COURSES);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);
			ResultSet queryResult = stmt.executeQuery();

			while (queryResult.next()) {
				availableCourseList
						.add(new Course(queryResult.getString("courseId"), queryResult.getString("courseName"),
								queryResult.getString("instructorId"), queryResult.getInt("seats")));
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		} 

		return availableCourseList;
	}


	/**
	 * Method to view courses already registered by the student
	 * @param studentId id of the student
	 * @param semester semester of the student
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Course> viewRegisteredCourses(String studentId, int semester) throws SQLException {

		Connection conn = DBUtils.getConnection();
		List<Course> registeredCourseList = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_REGISTERED_COURSES);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				registeredCourseList.add(new Course(rs.getString("courseId"), rs.getString("courseName"),
						rs.getString("instructorId"), rs.getInt("seats")));

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 

		return registeredCourseList;
	}


	/**
	 * Method to retrieve report card
	 * @param studentId id of the student
	 * @param semester semester of the student
	 * @return Report card object
	 * @throws SQLException
	 */
	@Override
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		ReportCard reportCard = null;
		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_REPORT_CARD);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);
			ResultSet queryResult = stmt.executeQuery();

			AdminDaoInterface obj=AdminDaoOperation.getInstance();
			HashMap<String, String> grades = obj.fetchGrades(studentId, semester);
			while(queryResult.next()) {
				reportCard = new ReportCard(studentId,grades, semester, Float.parseFloat(queryResult.getString("cpi")));
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
		return reportCard;
	}


	/**
	 * Method to pay fee
	 * @param payment payment object
	 * @return boolean value for successful/unsuccessful payment
	 * @throws SQLException
	 */
	@Override
	public boolean payFee(Payment payment) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.INSERT_PAYMENT);
			stmt.setString(1, payment.getStudentId());
			stmt.setString(2, payment.getPaymentId());
			stmt.setString(3, payment.getStatus());
			stmt.setInt(4, payment.getAmount());
			stmt.setString(5, payment.getNotificationId());
			stmt.setInt(6, payment.getSemester());
			stmt.execute();
			return true;

		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
		
		return false;
	}


	/**
	 * Method to view the fee to be paid by the student
	 * @param studentId id of the student
	 * @param semester semester of the student
	 * @return Payment object
	 */
	@Override
	public Payment viewFee(String studentId,int semester) {
		Connection conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_PAYMENT);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);
			
			
			ResultSet q = stmt.executeQuery();
			
			while(q.next())
				return new Payment(q.getString("paymentId"),q.getString("studentId_payment"),q.getInt("amount"),q.getString("status"),q.getString("notificationId"),q.getInt("semester"));
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
