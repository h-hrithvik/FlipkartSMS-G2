package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

public interface UserDaoInterface {
	
	/**
	 * Method to verify credentials of Users from DataBase
	 * @param userId
	 * @param password
	 * @throws UserNotFoundException
	 * @return boolean for successful/unsuccessful login
	 */
	public boolean verifyCredentials(String userId,String password) throws UserNotFoundException;

	/**
	 * Method to update password of user in DataBase
	 * @param userId
	 * @param password
	 * @return Update Password operation Status
	 */
	public boolean updatePassword(String userId, String password) throws UserNotFoundException;
	
	/**
	 * Method to get Role of User from DataBase
	 * @param userId
	 * @throws UserNotFoundException
	 * @return Role
	 */
	public String getRole(String userId) throws UserNotFoundException;
	

}
