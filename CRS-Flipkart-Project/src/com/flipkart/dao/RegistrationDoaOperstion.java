/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;

/**
 * @author WIN 10
 *
 */
public class RegistrationDoaOperstion implements RegistrationDaoInterface {

	@Override
	public boolean addCourse(String courseId, String studentId, List<Course> courseList) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCourse(String courseId, String studentId, List<Course> registeredCourseList)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> viewCourses(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> viewRegisteredCourses(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double payFee(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
