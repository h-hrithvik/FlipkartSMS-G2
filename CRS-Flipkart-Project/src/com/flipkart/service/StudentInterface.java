package com.flipkart.service;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;

public interface StudentInterface {
	
	public Boolean checkIsVerified(Student student);

	public ReportCard viewReportCard(Student student);
	
}
