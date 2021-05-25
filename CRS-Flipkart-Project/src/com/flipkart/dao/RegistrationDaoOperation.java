/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtils;

/**
 * @author WIN 10
 *
 */
public class RegistrationDaoOperation implements RegistrationDaoInterface {

	private PreparedStatement stmt = null;
	
	@Override
	public boolean addCourse(String courseId, String studentId, List<Course> courseList) throws SQLException {

		Connection conn = DBUtils.getConnection();

		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.ADD_COURSE);
			stmt.setString(1, studentId);
			stmt.setString(2, courseId);

			stmt.executeUpdate();

			stmt = conn.prepareStatement(SQLQueriesConstants.DECREMENT_COURSE_SEATS);
			stmt.setString(1, courseId);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			stmt.close();
			conn.close();
		}
		return false;
	}

	@Override
	public boolean removeCourse(String courseId, String studentId, List<Course> registeredCourseList)
			throws SQLException {
		Connection conn = DBUtils.getConnection();
		
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstants.DROP_COURSE_QUERY);
			stmt.setString(1, courseId);
			stmt.setString(2, studentId);
			stmt.execute();
			
			stmt = conn.prepareStatement(SQLQueriesConstants.INCREMENT_SEAT_QUERY);
			stmt.setString(1, courseId);
			stmt.execute();
			
			stmt.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			stmt.close();
			conn.close();
		}
		
		return false;
	}

	@Override
	public List<Course> viewCourses(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		List<Course> availableCourseList = new ArrayList<>();
		Connection conn = DBUtils.getConnection();
		
		try 
		{
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_AVAILABLE_COURSES);
			stmt.setInt(1, semester);
			ResultSet queryResult = stmt.executeQuery();

			while (queryResult.next()) {
				availableCourseList.add(new Course(queryResult.getString("courseId"), queryResult.getString("courseName"),
						queryResult.getString("professorId"), queryResult.getInt("seats")));

			}
			
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			stmt.close();
			conn.close();
		}
		
		return availableCourseList;
	}

	@Override
	public List<Course> viewRegisteredCourses(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		List<Course> registeredCourseList = new ArrayList<>();
		try 
		{
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_REGISTERED_COURSES);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				registeredCourseList.add(new Course(rs.getString("courseId"), rs.getString("courseName"),
						rs.getString("professorId"), rs.getInt("seats")));

			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		} 
		finally
		{
			stmt.close();
			conn.close();
		}
		
		return registeredCourseList;
	}

	@Override
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		ReportCard reportCard = new ReportCard();
		try
		{
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_GRADE);
			stmt.setString(1, studentId);
			stmt.setInt(2, semester);
//			ResultSet reportCard = stmt.executeQuery();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			stmt.close();
			conn.close();
			
		}
		
		return null;
	}

	@Override
	public double payFee(String studentId, int semester) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
