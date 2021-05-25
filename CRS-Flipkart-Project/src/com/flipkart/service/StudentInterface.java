package com.flipkart.service;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;

public interface StudentInterface {

	/**
	 * Function to know whether the student profile is verified by admin or not
	 * 
	 * @param student
	 * @return verified status
	 */
	public Boolean checkIsVerified(Student student);

	/**
	 * Function to view report card for student
	 * 
	 * @param student
	 * @return report card
	 */
	public ReportCard viewReportCard(Student student);

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
	 * @return status is new student successfully created or not
	 */
	public Boolean registerStudent(String userName, String phoneNumber, String address, String userId,
			String userPassword, String type, String rollNumber, String branch, Boolean isVerified);

}
