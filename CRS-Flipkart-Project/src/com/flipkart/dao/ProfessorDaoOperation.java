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
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

/**
 * @author hp
 *
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface{
	

	/**
	 * Method to get Courses by Professor Id using SQL Commands
	 * @param userId, professor id of the professor
	 * @return get the courses offered by the professor.
	 */
	@Override
	public List<Course> getCoursesByProfessor(String profId) {
		Connection connection=DBUtils.getConnection();
		List<Course> courseList=new ArrayList<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_COURSES);
			
			statement.setString(1, profId);
			
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				courseList.add(new Course(results.getString("courseId"),results.getString("courseName"),results.getString("instructorId"),results.getInt("seats")));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseList;
		
	}

	/**
	 * Method to view list of enrolled Students using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 */
	@Override
	public List<EnrolledStudent> getStudents(String profId) {
		Connection connection=DBUtils.getConnection();
		List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_ENROLLED_STUDENTS);
			statement.setString(1, profId);
			
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				enrolledStudents.add(new EnrolledStudent(results.getString("courseId"),results.getString("courseName"),results.getString("studentId")));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return enrolledStudents;
	}
	
	/**
	 * Method to Grade a student using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseId: course code for the corresponding 
	 * @param: semester: semester for the corresponding 
	 * @return: returns the status after adding the grade
	 */
	public Boolean addGrade(String studentId,String courseId,int semester,String grade) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.ADD_GRADE);
			
			
			statement.setString(1, studentId);
			statement.setString(2, courseId);
			statement.setInt(3, semester);
			statement.setString(4, grade);
			int row = statement.executeUpdate();
			
			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	

	
}
