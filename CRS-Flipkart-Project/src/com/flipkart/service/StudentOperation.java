package com.flipkart.service;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;

public class StudentOperation implements StudentInterface {

	@Override
	public Boolean checkIsVerified(Student student) throws StudentNotRegisteredException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReportCard viewReportCard(Student student) throws StudentNotRegisteredException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean registerStudent(String userName, String phoneNumber, String address, String userId,
			String userPassword, String type, String rollNumber, String branch, Boolean isVerified)
			throws UserAlreadyExistException {
		// TODO Auto-generated method stub
		return null;
	}

}
