/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;

/**
 * @author lenovo
 *
 */
public interface StudentDaoInterface {
	
	/**
	 * Method to add student to database
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 */
	public String addStudent(Student student) throws UserAlreadyExistException;
	
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 */
	public String getStudentId(String userId);
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	public int isApproved(String studentId);

}
