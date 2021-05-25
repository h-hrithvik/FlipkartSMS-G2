/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.User;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotApprovedExecption;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author arya_
 *
 */
public interface AdminDaoInterface {

	/**
	 * Delete Course using SQL commands
	 * @param courseCode
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException 
	 */
	public void deleteCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException;

	/**
	 * Add Course using SQL commands
	 * @param course
	 * @throws CourseFoundException
	 */
	public void addCourse(Course course) throws AddCourseException;
	
	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 * @throws StudentNotFoundException
	 */
	public void approveStudent(String studentId) throws StudentNotFoundForVerificationException;
	
	/**
	 * Add professor using SQL commands
	 * @param professor
	 * @throws ProfessorNotAddedException
	 * @throws UserIdAlreadyInUseException 
	 * @throws UserNotAddedException 
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserAlreadyExistException;
	
	/**
	 * Method to add user using SQL commands
	 * @param user
	 * @throws UserNotAddedException
	 * @throws UserIdAlreadyInUseException 
	 */
	public void addUser(User user) throws UserNotApprovedExecption, UserAlreadyExistException;
	
	/**
	 * Method to delete Professor from DB
	 * 
	 * @param professorId
	 * @throws ProfessorNotAddedException
	 */
	public void removeProfessor(String prefessorId) throws ProfessorNotAddedException,UserNotFoundException;

	/**
	 * Function to generate report
	 * 
	 * @param reportCard
	 * @throws StudentNotRegisteredException
	 */
	public void generateReport(ReportCard reportCard) throws StudentNotRegisteredException;

}
