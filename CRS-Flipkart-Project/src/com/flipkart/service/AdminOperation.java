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
	public void removeCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException {
		
		AdminDaoInterface adminDaoOperation=new AdminDaoOperation();

	}

	@Override
	/**
	 * Method to add Course to Course Catalog
	 * 
	 * @param course : Course object storing details of a course
	 * @throws AddCourseException
	 */
	public void addCourse(Course course) throws AddCourseException {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
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
			AdminDaoOperation obj = new AdminDaoOperation();
			obj.addProfessor(professor);
		} catch (ProfessorNotAddedException e) {
			System.out.println(e.getMessage());
		} catch (UserAlreadyExistException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * Function to generate report
	 * 
	 * @param reportCard
	 * @throws StudentNotRegisteredException
	 */
	public void generateReport(String StudentId,int semester) throws StudentNotRegisteredException {
		try {
			AdminDaoOperation obj = new AdminDaoOperation();
			HashMap<String, String> gradecrd = obj.fetchGrades(StudentId, semester);
			int counter=0,sum=0;
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
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * Method to delete Professor from DB
	 * 
	 * @param professorId
	 * @throws ProfessorNotAddedException
	 */
	public void removeProfessor(String professorId) throws ProfessorNotAddedException, ProfessorNotDeletedException {
		try {
			AdminDaoOperation obj = new AdminDaoOperation();
			obj.removeProfessor(professorId);
		} catch (ProfessorNotAddedException e) {
			System.out.println(e.getMessage());
		} catch (ProfessorNotDeletedException e) {
			System.out.println(e.getMessage());
		}
	}
}
