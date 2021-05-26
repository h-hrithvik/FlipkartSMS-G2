package com.flipkart.service;

import java.sql.SQLException;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;

public class StudentOperation implements StudentInterface {
	
	StudentDaoInterface studentDaoInterface= new StudentDaoOperation();
	RegistrationDaoInterface registerationDaoInterface= new RegistrationDaoOperation();
	

	@Override
	public boolean checkIsVerified(String studentId) throws StudentNotRegisteredException {
		
		// TODO Auto-generated method stub
		
		return studentDaoInterface.isApproved(studentId);
	}
	
	
	@Override
	public String getStudentId(String userId) {
		return studentDaoInterface.getStudentId(userId);
	
	}

	@Override
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException{
		// TODO Auto-generated method stub
		
		
		
		return registerationDaoInterface.viewReportCard(studentId, semester);
	}
	

	@Override
	public String registerStudent(String userName, String phoneNumber, String address, String userId,
			String password, String role, String rollNumber, String branch, Boolean isVerified)
			throws UserAlreadyExistException {
		// TODO Auto-generated method stub
		String studentId;
		try {
			Student newStudent = new Student(userName,phoneNumber,address,userId,password,role,rollNumber,branch,isVerified);
			studentId = studentDaoInterface.addStudent(newStudent);
			
		}
		catch(UserAlreadyExistException ex){
			throw ex;
		}
		return studentId;
	}

}
