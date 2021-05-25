package com.flipkart.service;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;

public interface StudentInterface {

	/**
	 * Function to know whether the student profile is verified by admin or not
	 * 
	 * @param student
	 * @throws StudentNotRegisteredException
	 * @return verified status
	 */
	public Boolean checkIsVerified(Student student) throws StudentNotRegisteredException;

	/**
	 * Function to view report card for student
	 * 
	 * @param student
	 * @throws StudentNotRegisteredException
	 * @return report card
	 */
	public ReportCard viewReportCard(Student student) throws StudentNotRegisteredException;

	/**
	 * Function to register new student
	 * 
	 * @param userName
	 * @param phoneNumber
	 * @param address
	 * @param userId
	 * @param userPassword
	 * @param type
	 * @param rollNumber
	 * @param branch
	 * @param isVerified
	 * @throws UserAlreadyExistException
	 * @return status is new student successfully created or not
	 */
	public Boolean registerStudent(String userName, String phoneNumber, String address, String userId,
			String userPassword, String type, String rollNumber, String branch, Boolean isVerified)
			throws UserAlreadyExistException;

}
