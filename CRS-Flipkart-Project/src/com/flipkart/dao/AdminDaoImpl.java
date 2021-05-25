/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.User;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.ProfessorNotDeletedException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotApprovedExecption;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtils;
/**
 * @author arya_
 *
 */
public class AdminDaoImpl {
	private PreparedStatement statement = null;
	Connection connection = DBUtils.getConnection();
	/**
	 * Delete Course using SQL commands
	 * @param courseCode
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException 
	 */
	public void deleteCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException{
		statement = null;
		try {
			String sql = SQLQueriesConstants.DELETE_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,courseId);
			int row = statement.executeUpdate();
			
			System.out.println(row + " entries deleted.");
			if(row == 0) {
				System.out.println(courseId+ " not in catalog!");
				throw new CourseNotFoundException(courseId);
			}

			System.out.println("Course with courseId: " + courseId + " deleted.");
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			throw new CourseNotDeletedException(courseId);
		}
	}

	/**
	 * Add Course using SQL commands
	 * @param course
	 * @throws CourseFoundException
	 */
	public void addCourse(Course course) throws AddCourseException{
		statement = null;
		try {
			
			String sql = SQLQueriesConstants.ADD_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, course.getCourseId());
			statement.setString(2, course.getCourseName());
			
			statement.setInt(3, 1);
			int row = statement.executeUpdate();
			
			System.out.println(row + " course added");
			if(row == 0) {
				System.out.println("Course with courseId: " + course.getCourseId() + "not added in catalog.");
				throw new AddCourseException(course.getCourseId());
			}
			
			System.out.println("Course with courseId: " + course.getCourseId() + " is added to catalog."); 
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			throw new AddCourseException(course.getCourseId());
			
		}
	}
	
	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 * @throws StudentNotFoundForVerificationException
	 */
	public void approveStudent(String studentId) throws StudentNotFoundForVerificationException{
		statement = null;
		try {
			String sql = SQLQueriesConstants.APPROVE_STUDENT_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,studentId);
			int row = statement.executeUpdate();
			
			System.out.println(row + " student approved.");
			if(row == 0) {
				throw new StudentNotFoundForVerificationException(studentId);
			}
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			
		}
	}
	
	/**
	 * Add professor using SQL commands
	 * @param professor
	 * @throws ProfessorNotAddedException
	 * @throws UserAlreadyExistException 
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserAlreadyExistException{
		try {
			
			this.addUser(professor);
			
		}catch (UserNotApprovedExecption e) {
			
			System.out.println(e.getMessage());
			throw new ProfessorNotAddedException(professor.getProfessorId());
			
		}catch (UserAlreadyExistException e) {
			
			System.out.println(e.getMessage());
			throw e;
			
		}		
		
		statement = null;
		try {
			
			String sql = SQLQueriesConstants.ADD_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, professor.getProfessorId());
			statement.setString(2, professor.getDepartment());
			int row = statement.executeUpdate();

			System.out.println(row + " professor added.");
			if(row == 0) {
				System.out.println("Professor with professorId: " + professor.getProfessorId() + " not added.");
				throw new ProfessorNotAddedException(professor.getProfessorId());
			}
			
			System.out.println("Professor with professorId: " + professor.getProfessorId() + " added."); 
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			throw new UserAlreadyExistException(professor.getProfessorId());
			
		} 
	}
	
	/**
	 * Method to add user using SQL commands
	 * @param user
	 * @throws UserNotApprovedExecption
	 * @throws UserAlreadyExistException 
	 */
	public void addUser(User user) throws UserNotApprovedExecption, UserAlreadyExistException{
		statement = null;
		try {
			
			String sql = SQLQueriesConstants.ADD_USER_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getUserId());
			statement.setString(2, user.getUserName());
			statement.setString(3, user.getUserPassword());
			statement.setString(4, user.getType().toString());
			statement.setString(5, user.getPhoneNumber().toString());
			statement.setString(6, user.getAddress());
			int row = statement.executeUpdate();
			
			System.out.println(row + " user added.");
			if(row == 0) {
				System.out.println("User with userId: " + user.getUserId() + " not added.");
				throw new UserNotApprovedExecption(user.getUserId()); 
			}

			System.out.println("User with userId: " + user.getUserId() + " added."); 
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			throw new UserAlreadyExistException(user.getUserId());
			
		}
	}
	/**
	 * Method to delete Professor from DB
	 * 
	 * @param professorId
	 * @throws ProfessorNotAddedException
	 * @throws ProfessorNotDeletedException
	 */
	public void removeProfessor(String prefessorId) throws ProfessorNotAddedException,ProfessorNotDeletedException{
		statement = null;
		try {
			String sql = SQLQueriesConstants.DELETE_PROFESSOR_QUERY;	// TO BE CHANGED
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,prefessorId);
			int row = statement.executeUpdate();
			
			System.out.println(row + " entries deleted.");
			if(row == 0) {
				System.out.println(prefessorId+ " not found!");
				throw new ProfessorNotAddedException(prefessorId);
			}

			System.out.println("Professor with prefessorId: " + prefessorId + " deleted.");
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			throw new ProfessorNotDeletedException(prefessorId);		
		}
	}

	/**
	 * Function to generate report
	 * 
	 * @param reportCard
	 * @throws StudentNotRegisteredException
	 */
	public void generateReport(ReportCard reportCard) throws StudentNotRegisteredException{
		statement = null;
		try {
			
			String sql = SQLQueriesConstants.ADD_REPORT_CARD;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, reportCard.getStudentId());
			statement.setInt(2, reportCard.getSem());
			statement.setFloat(3, reportCard.getCPI());
			int row = statement.executeUpdate();
			
			System.out.println(row + " Report Card Generated.");
			if(row == 0) {
				System.out.println("For student with StudentId: " + reportCard.getStudentId() + " no Report generated.");
				throw new StudentNotRegisteredException(reportCard.getStudentId()); 
			}

			System.out.println("User with userId: " + reportCard.getStudentId() + " added."); 
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			throw new StudentNotRegisteredException(reportCard.getStudentId());
			
		}
	}


}
