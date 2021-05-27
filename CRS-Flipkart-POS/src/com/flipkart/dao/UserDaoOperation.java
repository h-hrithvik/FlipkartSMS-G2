package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtils;

public class UserDaoOperation implements UserDaoInterface {

	private static Logger logger = Logger.getLogger(UserDaoOperation.class);
	private static volatile UserDaoOperation instance=null;

	/**
	 * Default Constructor
	 */
	private UserDaoOperation()
	{

	}

	public static UserDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(UserDaoOperation.class){
				instance=new UserDaoOperation();
			}
		}
		return instance;
	}

	/**
	 * Method to update password of user in DataBase
	 * @param userId
	 * @param password
	 * @return Update Password operation Status
	 */
	@Override
	public boolean updatePassword(String userId, String password) throws UserNotFoundException {
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.UPDATE_PASSWORD);
			statement.setString(1, password);
			statement.setString(2, userId);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next())
				throw new UserNotFoundException(userId);
			return true;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} 
		return false;
	}


	/**
	 * Method to verify credentials of Users from DataBase
	 * 
	 * @param userId
	 * @param password
	 * @throws UserNotFoundException
	 */
	@Override
	public boolean verifyCredentials(String userId, String password) throws UserNotFoundException {
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.VERIFY_CREDENTIALS);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next())
				throw new UserNotFoundException(userId);
			else if (password.equals(resultSet.getString("password")))
				return true;
			else
				return false;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

		return false;
	}

	/**
	 * Method to get Role of User from DataBase
	 * 
	 * @param userId
	 * @throws UserNotFoundException
	 * @return Role
	 */
	@Override
	public String getRole(String userId) throws UserNotFoundException {
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_ROLE);
			statement.setString(1, userId);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next())
				throw new UserNotFoundException(userId);
			else
				return resultSet.getString("role");
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} 
		return null;
	}

}
