/**
 * 
 */
package com.flipkart.service;

import java.util.HashMap;

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
import org.apache.log4j.Logger;
/**
 * @author arya_
 *
 */
public class AdminOperation implements AdminInterface {

	@Override
	/**
	 * Method to Delete Course from Course Catalog
	 * 
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException
	 */
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
	

	AdminDaoInterface obj =AdminDaoOperation.getInstance();
	public void removeCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException {
		try {
			obj.deleteCourse(courseId);
		} catch (CourseNotFoundException e) {
			logger.error(e.getMessage());
		} catch (CourseNotDeletedException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	/**
	 * Method to add Course to Course Catalog
	 * 
	 * @param course : Course object storing details of a course
	 * @throws AddCourseException
	 */
	public void addCourse(Course course) throws AddCourseException {
		try {
			obj.addCourse(course);
		} catch (AddCourseException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	/**
	 * Method to approve a Student
	 * 
	 * @param studentId
	 * @throws StudentNotFoundForApprovalException
	 * @return Approval Status
	 */
	public boolean approveStudent(String studentId) throws StudentNotFoundForVerificationException {
		try {
			obj.approveStudent(studentId);
			return true;
		} catch (StudentNotFoundForVerificationException e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	/**
	 * Method to add Professor to DB
	 * 
	 * @param professor : Professor Object storing details of a professor
	 * @throws ProfessorNotAddedException
	 * @throws UserAlreadyExistException
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserAlreadyExistException {
		try {
			obj.addProfessor(professor);
		} catch (ProfessorNotAddedException e) {
			logger.error(e.getMessage());
		} catch (UserAlreadyExistException e) {
			logger.error(e.getMessage());
		}
	}

	
	/**
	 * Function to generate report
	 * 
	 * @param reportCard
	 * @throws StudentNotRegisteredException
	 */
	int counter=0,sum=0;
	@Override
	public void generateReport(String StudentId,int semester) throws StudentNotRegisteredException {
		
		try {
			HashMap<String, String> gradecrd = obj.fetchGrades(StudentId, semester);
			gradecrd.forEach((k,v) -> {
				counter = counter+1;
				if(v == "A")
					sum += 4;
				else if(v == "B")
					sum += 3;
				else if(v == "C")
					sum += 2;
				else
					sum += 1;
			});
			float CPI = sum/counter;
			obj.generateReport(semester, StudentId, CPI);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	/**
	 * Method to delete Professor from DB
	 * 
	 * @param professorId
	 * @throws ProfessorNotAddedException
	 * @throws ProfessorNotDeletedException
	 */
	public void removeProfessor(String professorId) throws ProfessorNotAddedException, ProfessorNotDeletedException {
		try {
			obj.removeProfessor(professorId);
		} catch (ProfessorNotAddedException e) {
			logger.error(e.getMessage());
		} catch (ProfessorNotDeletedException e) {
			logger.error(e.getMessage());
		}
	}

}
