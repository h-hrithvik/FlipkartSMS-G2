/**
 * 
 */
package com.flipkart.service;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.ProfessorNotDeletedException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;

/**
 *
 * @author JEDI-02
 * Implementations of Admin Operations
 *
 */

public class AdminOperation implements AdminInterface {

	private static Logger logger = Logger.getLogger(AdminOperation.class);
	private static volatile AdminOperation instance = null;

	private AdminOperation()
	{

	}

	/**
	 * Method to make AdminOperation Singleton
	 */
	public static AdminOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminOperation.class){
				instance = new AdminOperation();
			}
		}
		return instance;
	}


	AdminDaoInterface adminDaoOperation =AdminDaoOperation.getInstance();


	/**
	 * Method to Delete Course from Course Catalog
	 * 
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException
	 */
	@Override
	public void removeCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException {
		try {
			adminDaoOperation.deleteCourse(courseId);
		} catch (CourseNotFoundException e) {
			logger.error(e.getMessage());
		} catch (CourseNotDeletedException e) {
			logger.info(e.getMessage());
		}
	}


	/**
	 * Method to add Course to Course Catalog
	 * 
	 * @param course : Course object storing details of a course
	 * @throws AddCourseException
	 */
	@Override
	public void addCourse(Course course) throws AddCourseException {
		try {
			adminDaoOperation.addCourse(course);
		} catch (AddCourseException e) {
			logger.error(e.getMessage());
		}
	}


	/**
	 * Method to approve a Student
	 * 
	 * @param studentId id of student to be approved
	 * @throws StudentNotFoundForVerificationException
	 * @return Approval Status
	 */
	@Override
	public boolean approveStudent(String studentId) throws StudentNotFoundForVerificationException {
		try {
			adminDaoOperation.approveStudent(studentId);
			return true;
		} catch (StudentNotFoundForVerificationException e) {
			logger.error(e.getMessage());
		}
		return false;
	}


	/**
	 * Method to add Professor to DB
	 * 
	 * @param professor : Professor Object storing details of a professor
	 * @throws ProfessorNotAddedException
	 * @throws UserAlreadyExistException
	 */
	@Override
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserAlreadyExistException {
		try {
			adminDaoOperation.addProfessor(professor);
		} catch (ProfessorNotAddedException e) {
			logger.error(e.getMessage());
		} catch (UserAlreadyExistException e) {
			logger.error(e.getMessage());
		}
	}





	/**
	 * Method to generate report
	 *
	 * @param StudentId id of student
	 * @param semester semester of student
	 * @throws StudentNotRegisteredException
	 */
	int counter=0,sum=0;
	@Override
	public void generateReport(String StudentId, int semester) throws StudentNotRegisteredException {

		try {
			HashMap<String, String> gradecrd = adminDaoOperation.fetchGrades(StudentId, semester);
			gradecrd.forEach((k, v) -> {
				counter = counter + 1;
				if (v.toString().equals("A".toString()))
					sum += 4;
				else if (v.toString().equals("B".toString()))
					sum += 3;
				else if (v.toString().equals("C".toString()))
					sum += 2;
				else
					sum += 1;
			});
			float CPI = sum / counter;
			adminDaoOperation.generateReport(semester, StudentId, CPI);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}


	/**
	 * Method to delete Professor from DB
	 * 
	 * @param professorId id of professor
	 * @throws ProfessorNotAddedException
	 * @throws ProfessorNotDeletedException
	 */
	@Override
	public void removeProfessor(String professorId) throws ProfessorNotAddedException, ProfessorNotDeletedException {
		try {
			adminDaoOperation.removeProfessor(professorId);
		} catch (ProfessorNotAddedException e) {
			logger.error(e.getMessage());
		} catch (ProfessorNotDeletedException e) {
			logger.error(e.getMessage());
		}
	}

}
