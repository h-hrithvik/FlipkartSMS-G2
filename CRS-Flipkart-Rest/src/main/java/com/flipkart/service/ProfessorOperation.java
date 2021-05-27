/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;
/**
 * @author JEDI-02
 *	Implements Professor Operations
 */
public class ProfessorOperation implements ProfessorInterface {

	private static volatile ProfessorOperation instance=null;
	ProfessorDaoInterface professorDaoInterface=ProfessorDaoOperation.getInstance();
	private ProfessorOperation()
	{

	}

	/**
	 * Method to make ProfessorOperation Singleton
	 * @return
	 */
	public static ProfessorOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(ProfessorOperation.class){
				instance=new ProfessorOperation();
			}
		}
		return instance;
	}

	/**
	 * Method to get list of all course a professor is teaching
	 * @param professorId: professor id
	 * @return List of courses the professor is teaching
	 */
	@Override
	public List<Course> getCourses(String professorId) {
		//call the DAO class
		//get the courses for the professor
		List<Course> coursesOffered=new ArrayList<Course>();
		try
		{
			coursesOffered=professorDaoInterface.getCoursesByProfessor(professorId);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return coursesOffered;
	}


	/**
	 * Method to view all the enrolled students
	 * @param professorId: professor id
	 * @return List of enrolled students
	 */
	@Override
	public List<EnrolledStudent> viewStudents(String professorId){
		// TODO Auto-generated method stub
		List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
		try
		{
			enrolledStudents=professorDaoInterface.getStudents(professorId);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return enrolledStudents;
	}


	/**
	 * Method to grade a Student
	 * @param studentId unique id of the student
	 * @param courseId unique id of the course
	 * @param grade grade to be added for student in the course
	 * @return boolean indicating if grade is added or not
	 * @throws GradeNotAddedException
	 */
	@Override
	public boolean addGrade(String studentId, String courseId,int semester, String grade)
			throws StudentNotRegisteredException, StudentNotFoundForVerificationException, GradeNotAddedException {
		// TODO Auto-generated method stub
		try
		{
			professorDaoInterface.addGrade(studentId, courseId,semester, grade);
		}
		catch(Exception ex)
		{
			throw new GradeNotAddedException(studentId);
		}
		return true;
	}

}
