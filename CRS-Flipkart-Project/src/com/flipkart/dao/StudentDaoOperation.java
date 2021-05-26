/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.service.StudentOperation;
import com.flipkart.utils.DBUtils;

/**
 * @author lenovo
 *
 */
public class StudentDaoOperation implements StudentDaoInterface {

	
	/**
	 * Default Constructor
	 */
	public StudentDaoOperation()
	{
		
	}
	
	/**
	 * Method to add student to database
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 */
	@Override
	public String addStudent(Student student) throws UserAlreadyExistException{
		
		Connection connection=DBUtils.getConnection();
		String studentId="";
		try{
			//open db connection
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
			preparedStatement.setString(1, student.getUserId().toString());
			preparedStatement.setString(2, student.getUserName().toString());
			preparedStatement.setString(3, student.getUserPassword().toString());
			preparedStatement.setString(4, student.getType().toString());
			preparedStatement.setString(5, student.getPhoneNumber().toString());
			preparedStatement.setString(6, student.getAddress().toString());
			int rowsAffected=preparedStatement.executeUpdate();
			if(rowsAffected==1)
			{
				//add the student record
				//"insert into student (userId,branchName,batch,isApproved) values (?,?,?,?)";
				PreparedStatement preparedStatementStudent;
				preparedStatementStudent=connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT,Statement.RETURN_GENERATED_KEYS);
				preparedStatementStudent.setString(1,student.getUserId().toString());
				preparedStatementStudent.setString(2,student.getUserId().toString());
				preparedStatementStudent.setString(3, student.getBranch().toString());
				preparedStatementStudent.setBoolean(4, false);
				preparedStatementStudent.executeUpdate();
				ResultSet results=preparedStatementStudent.getGeneratedKeys();
				if(results.next())
					studentId=results.getString(0);
			}
			
			
		}
		catch(Exception ex)
		{
			throw new UserAlreadyExistException(student.getUserId());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"SQL error");
				e.printStackTrace();
			}
		}
		return studentId;
	}
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 */
	@Override
	public String getStudentId(String userId) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_STUDENT_ID);
			statement.setString(1, userId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getString(0);
			}
				
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return "";
	}
	
	
	
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	@Override
	public boolean isApproved(String studentId) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.IS_APPROVED);
			statement.setString(1, studentId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getBoolean(0);
			}
				
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return false;
	}
}
