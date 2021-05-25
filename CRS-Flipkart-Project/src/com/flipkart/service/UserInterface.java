package com.flipkart.service;

import com.flipkart.bean.User;

public interface UserInterface {
	/**
	 * Function to add new user to system
	 * 
	 * @param user
	 * @return status if the user is created or not
	 */
	public boolean addUser(User user);

	/**
	 * Function to verify credentials while login
	 * 
	 * @param userId
	 * @param userPassword
	 * @return status if the credentials are valid
	 */
	public boolean verifyCredentials(String userId, String userPassword);

	/**
	 * Function to change password of the user
	 * 
	 * @param userId
	 * @param newPassword
	 * @return status success/failure
	 */
	public boolean changePassword(String userId, String newPassword);
}