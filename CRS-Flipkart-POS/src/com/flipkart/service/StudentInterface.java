package com.flipkart.service;

import java.sql.SQLException;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;

public interface StudentInterface {

	/**
	 * Function to know whether the student profile is verified by admin or not
	 * 
	 * @param studentId
	 * @throws StudentNotRegisteredException
	 * @return verified status
	 */
	public int checkIsVerified(String studentId) throws StudentNotRegisteredException;

	/**
	 * Function to view report card for student
	 * 
	 * @param studentId
	 * @throws StudentNotRegisteredException
	 * @return report card
	 */
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException;

	
	
	/**
	 * Method to get Student ID from User ID
	 * @param userId
	 * @return Student ID
	 */
	public String getStudentId(String userId);
	
	
	
	/**
	 * Function to register new student
	 * 
	 * @param userName
	 * @param phoneNumber
	 * @param address
	 * @param userId
	 * @param userPassword
	 * @param role
	 * @param rollNumber
	 * @param branch
	 * @param isVerified
	 * @throws UserAlreadyExistException
	 * @return status is new student successfully created or not
	 */
	public String registerStudent(String userName, String phoneNumber, String address, String userId,
			String userPassword, String role, String rollNumber, String branch, Boolean isVerified)
			throws UserAlreadyExistException;

}
