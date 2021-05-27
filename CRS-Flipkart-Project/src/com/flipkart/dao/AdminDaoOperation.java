/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.apache.log4j.Logger;
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
public class AdminDaoOperation implements AdminDaoInterface {

	private static volatile AdminDaoOperation instance = null;
	private static Logger logger = Logger.getLogger(AdminDaoOperation.class);

	private PreparedStatement statement = null;

	/**
	 * Default Constructor
	 */
	private AdminDaoOperation(){}

	/**
	 * Method to make AdminDaoOperation Singleton
	 * @return
	 */
	public static AdminDaoOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminDaoOperation.class){
				instance = new AdminDaoOperation();
			}
		}
		return instance;
	}


	Connection connection = DBUtils.getConnection();

	/**
	 * Delete Course using SQL commands
	 * 
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException
	 */
	public void deleteCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException {
		statement = null;
		try {
			String sql = SQLQueriesConstants.DELETE_COURSE_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, courseId);
			int row = statement.executeUpdate();

			logger.info(row + " entries deleted.");
			if (row == 0) {
				logger.info(courseId + " not in catalog!");
				throw new CourseNotFoundException(courseId);
			}

			logger.info("Course with courseId: " + courseId + " deleted.");

		} catch (SQLException se) {

			logger.error(se.getMessage());
			throw new CourseNotDeletedException(courseId);
		}
	}


	/**
	 * Add Course using SQL commands
	 * 
	 * @param course
	 * @throws AddCourseException
	 */
	public void addCourse(Course course) throws AddCourseException {
		statement = null;
		try {
			
			String sql = SQLQueriesConstants.ADD_COURSE_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, course.getCourseId());
			statement.setString(2, course.getCourseName());
			statement.setString(3, course.getInstructorId());
			statement.setInt(4, 10);
			int row = statement.executeUpdate();

			logger.info(row + " course added");
			if (row == 0) {
				
				throw new AddCourseException(course.getCourseId());
			}

			logger.info("Course with courseId: " + course.getCourseId() + " is added to catalog.");

		} catch (AddCourseException | SQLException se) {

			
			logger.error("Kindly check your InstructorId or your CourseID.");
			logger.error("Course not added.......Try again!!");

		}
	}


	/**
	 * Approve Student using SQL commands
	 * 
	 * @param studentId
	 * @throws StudentNotFoundForVerificationException
	 */
	public void approveStudent(String studentId) throws StudentNotFoundForVerificationException {
		statement = null;
		try {
			String sql = SQLQueriesConstants.APPROVE_STUDENT_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, studentId);
			int row = statement.executeUpdate();

			logger.info(row + " student approved.");
			if (row == 0) {
				throw new StudentNotFoundForVerificationException(studentId);
			}

		} catch (SQLException se) {

			logger.error(se.getMessage());

		}
	}


	/**
	 * Add professor using SQL commands
	 * 
	 * @param professor
	 * @throws ProfessorNotAddedException
	 * @throws UserAlreadyExistException
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserAlreadyExistException {
		try {
			this.addUser(professor);

		} catch (UserNotApprovedExecption e) {

			logger.info(e.getMessage());
			throw new ProfessorNotAddedException(professor.getProfessorId());

		} catch (UserAlreadyExistException e) {

			logger.error(e.getMessage());
			throw e;

		}

		statement = null;
		try {

			String sql = SQLQueriesConstants.ADD_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, professor.getProfessorId());
			statement.setString(2, professor.getProfessorId());
			statement.setString(3, professor.getDepartment());
			int row = statement.executeUpdate();

			logger.info(row + " professor added.");
			if (row == 0) {
				logger.info("Professor with professorId: " + professor.getProfessorId() + " not added.");
				throw new ProfessorNotAddedException(professor.getProfessorId());
			}

			logger.info("Professor with professorId: " + professor.getProfessorId() + " added.");

		} catch (SQLException se) {

			logger.error(se.getMessage());
			throw new UserAlreadyExistException(professor.getProfessorId());

		}
	}

	/**
	 * Method to add user using SQL commands
	 * @param user object of user that needs to be added
	 * @throws UserNotApprovedExecption
	 * @throws UserAlreadyExistException
	 */
	public void addUser(Professor user) throws UserNotApprovedExecption, UserAlreadyExistException {
		statement = null;
		try {
			String sql = SQLQueriesConstants.ADD_USER_QUERY;
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
			preparedStatement.setString(1, user.getUserId().toString());
			preparedStatement.setString(2, user.getUserName().toString());
			preparedStatement.setString(3, user.getUserPassword().toString());
			preparedStatement.setString(4, user.getType().toString());
			preparedStatement.setString(5, user.getPhoneNumber().toString());
			preparedStatement.setString(6, user.getAddress().toString());
			int row = preparedStatement.executeUpdate();
			logger.info(row + " user added.");
			if (row == 0) {
				logger.info("User with userId: " + user.getUserId() + " not added.");
				throw new UserNotApprovedExecption(user.getUserId());
			}

			logger.info("User with userId: " + user.getUserId() + " added.");

		} catch (SQLException se) {

			logger.error(se.getMessage());
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
	public void removeProfessor(String professorId) throws UserNotFoundException, ProfessorNotDeletedException {
		statement = null;
		try {
			String sql = SQLQueriesConstants.DELETE_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, professorId);
			int row = statement.executeUpdate();

			System.out.println(row + " entries deleted.");
			if (row == 0) {
				logger.info(professorId + " not found!");
				throw new UserNotFoundException(professorId);
			}
			sql = SQLQueriesConstants.DELETE_USER_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setString(1, professorId);
			statement.executeUpdate();
			logger.info("Professor with professorId: " + professorId + " deleted.");

		} catch (SQLException se) {

			logger.error(se.getMessage());
			throw new ProfessorNotDeletedException(professorId);
		}
	}

	/**
	 * Function to generate report
	 * @param semester
	 * @param StudentId
	 * @param CPI
	 * @throws StudentNotRegisteredException
	 */
	public void generateReport(int semester, String StudentId, float CPI) throws StudentNotRegisteredException {
		statement = null;
		try {

			String sql = SQLQueriesConstants.ADD_REPORT_CARD;
			statement = connection.prepareStatement(sql);

			statement.setString(1, StudentId);
			statement.setFloat(2, CPI);
			statement.setInt(3, semester);
			int row = statement.executeUpdate();

			logger.info(row + " Report Card Generated.");
			if (row == 0) {
				logger.info("For student with StudentId: " + StudentId + " no Report generated.");
				throw new StudentNotRegisteredException(StudentId);
			}

			logger.info("User with userId: " + StudentId + " added.");

		} catch (SQLException se) {
			logger.error("Either Student Not Registered or grades not added.");
		}
	}

	public HashMap<String, String> fetchGrades(String StudentId, int semester) {
		statement = null;
		try {
			String sql = SQLQueriesConstants.FETCH_GRADES;
			statement = connection.prepareStatement(sql);
			statement.setString(1, StudentId);
			statement.setInt(2, semester);
			ResultSet resultSet = statement.executeQuery();
			HashMap<String, String> gradecrd = new HashMap<String, String>();
			while (resultSet.next()) {
				String courseId = resultSet.getString("courseId");
				String grade = resultSet.getString("grade");
				gradecrd.put(courseId, grade);
			}
			return gradecrd;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
