package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.bean.ReportCard;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitReachedException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.PaymentNotFoundException;
import com.flipkart.exception.StudentNotRegisteredException;

public class RegistrationOperation implements RegistrationInterface {

	public RegistrationOperation() {
	}

	RegistrationDaoInterface registrationDaoInterface = new RegistrationDaoOperation();

	@Override
	public boolean addCourse(String courseId, String studentId, int semester) throws CourseNotFoundException,AddCourseException, CourseLimitReachedException, SQLException {

		try {
			if (registrationDaoInterface.numOfRegisteredCourses(studentId, semester) == 6) {
				throw new CourseLimitReachedException(semester);
			}
			if (registrationDaoInterface.isRegistered(courseId, studentId, semester)) {
				throw new CourseAlreadyRegisteredException(courseId);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch(CourseLimitReachedException e) {
			e.printStackTrace();
		} catch (CourseAlreadyRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return registrationDaoInterface.addCourse(courseId, studentId, semester);
	}

	@Override
	public boolean dropCourse(String courseId, String studentId, int semester)
			throws CourseNotDeletedException, SQLException {
		// TODO Auto-generated method stub
		try {
			if(!registrationDaoInterface.isRegistered(courseId, studentId, semester)) {
				throw new StudentNotRegisteredException(studentId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StudentNotRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registrationDaoInterface.removeCourse(courseId, studentId, semester);
	}

	@Override
	public List<Course> viewCourses(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		return registrationDaoInterface.viewCourses(studentId, semester);
	}

	@Override
	public List<Course> viewRegisteredCourses(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		return registrationDaoInterface.viewRegisteredCourses(studentId, semester);
	}

	@Override
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException {
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
	public boolean payFee(Payment payment) throws PaymentNotFoundException,SQLException {
		// TODO Auto-generated method stub
		return registrationDaoInterface.payFee(payment);
	}
	
	@Override
	public Payment viewFee(String studentId,int semester) throws SQLException{
		return registrationDaoInterface.viewFee(studentId, semester);
	}

}
