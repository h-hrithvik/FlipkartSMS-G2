package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtils;

public class UserDaoOperation implements UserDaoInterface {
	/**
	 * @param userID
	 * @param password
	 * @throws UserNotFoundException
	 */
	@Override
	public boolean verifyCredentials(String userId, String password) throws UserNotFoundException {
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.UPDATE_PASSWORD);
			statement.setString(1, password);
			statement.setString(2, userId);
			ResultSet resultSet = statement.executeQuery();
			if(!resultSet.next())
				throw new UserNotFoundException(userId);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return false;
	}
	/**
	 * Method to verify credentials of Users from DataBase
	 * @param userId
	 * @param password
	 * @throws UserNotFoundException
	 */
	@Override
	public boolean updatePassword(String userId, String password) throws UserNotFoundException {
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.VERIFY_CREDENTIALS);
			preparedStatement.setString(1,userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(!resultSet.next())
				throw new UserNotFoundException(userId);
			else if(password.equals(resultSet.getString("password"))) 
				return true;
			else 
				return false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return false;
	}
	/**
	 * Method to get Role of User from DataBase
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
			if(!resultSet.next())
				throw new UserNotFoundException(userId);
			else
				return resultSet.getNString("role");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

}
