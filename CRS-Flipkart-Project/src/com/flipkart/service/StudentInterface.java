package com.flipkart.service;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;

public interface StudentInterface {
	
	public Boolean checkIsVerified(Student student);

	public ReportCard viewReportCard(Student student);
	
	public Boolean registerStudent(String userName, String phoneNumber, String address, String userId, String userPassword, String type,
			String rollNumber, String branch, Boolean isVerified);

}
