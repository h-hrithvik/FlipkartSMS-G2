package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

public interface UserDaoInterface {
	
	/**
	 * Method to verify credentials of Users from DataBase
	 * @param userId
	 * @param password
	 * @throws UserNotFoundException
	 */
	public boolean verifyCredentials(String userId,String password) throws UserNotFoundException;
	
	/**
	 * Method to update password of user in DataBase
	 * @param userID
	 * @throws UserNotFoundException
	 * @return Update Password operation Status
	 */
	//TODO Duplicate Function. Please remove it if its not necessary
	public boolean updatePassword(String userId, String password) throws UserNotFoundException;
	
	/**
	 * Method to get Role of User from DataBase
	 * @param userId
	 * @throws UserNotFoundException
	 * @return Role
	 */
	public String getRole(String userId) throws UserNotFoundException;
	
	
	/**
	 * Method to update password of user in DataBase
	 * @param userID
	 * @param newPassword
	 * @return Update Password operation Status
	 */
}
