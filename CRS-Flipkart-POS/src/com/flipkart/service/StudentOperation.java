package com.flipkart.service;

import java.sql.SQLException;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.PaymentNotFoundException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;
import org.apache.log4j.Logger;

public class StudentOperation implements StudentInterface {
	
	private static volatile StudentOperation instance=null;
	private static Logger logger = Logger.getLogger(StudentOperation.class);
	StudentDaoInterface studentDaoInterface=StudentDaoOperation.getInstance();
	RegistrationDaoInterface registrationDaoInterface = RegistrationDaoOperation.getInstance();

	public StudentOperation()
	{
		
	}
	/**
	 * Method to make StudentOperation Singleton
	 * @return
	 */
	public static StudentOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentOperation.class){
				instance=new StudentOperation();
			}
		}
		return instance;
	}



	@Override
	public int checkIsVerified(String studentId) throws StudentNotRegisteredException {
		
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
		
		
		
		try {
			return registrationDaoInterface.viewReportCard(studentId, semester);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PaymentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
