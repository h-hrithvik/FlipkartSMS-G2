package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.PaymentNotFoundException;

public class RegistrationOperation implements RegistrationInterface {

	@Override
	public boolean addCourse(String courseId, String studentId, List<Course> courseList) throws AddCourseException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dropCourse(String courseId, String studentId, List<Course> registeredCourseList)
			throws CourseNotDeletedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> viewCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> viewRegisteredCourses(String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportCard viewReportCard(String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double payFee(String studentId) throws PaymentNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}
