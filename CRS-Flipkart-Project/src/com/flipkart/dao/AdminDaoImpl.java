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

			System.out.println("Course with courseCode: " + courseId + " deleted.");
			
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
				System.out.println("Course with courseCode: " + course.getCourseId() + "not added to catalog.");
				throw new AddCourseException(course.getCourseId());
			}
			
			System.out.println("Course with courseCode: " + course.getCourseId() + " is added to catalog."); 
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			throw new AddCourseException(course.getCourseId());
			
		}
	}
	
	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 * @throws StudentNotFoundException
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
				//logger.error("Student with studentId: " + studentId + " not found.");
				throw new StudentNotFoundForVerificationException(studentId);
			}
			
			//logger.info("Student with studentId: " + studentId + " approved by admin.");
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			
		}
	}
	
	/**
	 * Add professor using SQL commands
	 * @param professor
	 * @throws ProfessorNotAddedException
	 * @throws UserIdAlreadyInUseException 
	 * @throws UserNotAddedException 
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserAlreadyExistException{
		try {
			
			this.addUser(professor);
			
		}catch (UserNotApprovedExecption e) {
			
			System.out.println(e.getMessage());
			throw new ProfessorNotAddedException(professor.getUserId());
			
		}catch (UserAlreadyExistException e) {
			
			System.out.println(e.getMessage());
			throw e;
			
		}		
		
		statement = null;
		try {
			
			String sql = SQLQueriesConstants.ADD_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, professor.getUserId());
			statement.setString(2, professor.getDepartment());
			int row = statement.executeUpdate();

			System.out.println(row + " professor added.");
			if(row == 0) {
				System.out.println("Professor with professorId: " + professor.getUserId() + " not added.");
				throw new ProfessorNotAddedException(professor.getUserId());
			}
			
			System.out.println("Professor with professorId: " + professor.getUserId() + " added."); 
			
		}catch(SQLException se) {
			
			System.out.println(se.getMessage());
			throw new UserAlreadyExistException(professor.getUserId());
			
		} 
	}
	
	/**
	 * Method to add user using SQL commands
	 * @param user
	 * @throws UserNotAddedException
	 * @throws UserIdAlreadyInUseException 
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
			statement.setString(5, user.getAddress());
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
	 */
	public void removeProfessor(String prefessorId) throws ProfessorNotAddedException{
		
	}

	/**
	 * Function to generate report
	 * 
	 * @param reportCard
	 * @throws StudentNotRegisteredException
	 */
	public void generateReport(ReportCard reportCard) throws StudentNotRegisteredException{
		
	}


}
