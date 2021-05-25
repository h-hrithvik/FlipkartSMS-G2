/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.exception.AddCourseException;

/**
 * @author arya_
 *
 */
public class AdminOperation implements AdminInterface {

	@Override
	public void removeCourse(String courseId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCourse(Course course) throws AddCourseException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean approveStudent(String studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateReport(ReportCard reportCard) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeProfessor(String prefessorId) {
		// TODO Auto-generated method stub

	}

}
