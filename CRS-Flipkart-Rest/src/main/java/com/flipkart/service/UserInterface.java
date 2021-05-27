package com.flipkart.service;

import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {

	/**
	 * Function to verify credentials while login
	 * 
	 * @param userId
	 * @param userPassword
	 * @throws UserNotFoundException if user is not found to verify credentials
	 * @return status if the credentials are valid
	 */
	public boolean verifyCredentials(String userId, String userPassword) throws UserNotFoundException;

	/**
	 * Function to change password of the user
	 * 
	 * @param userId
	 * @param newPassword
	 * @throws UserNotFoundException
	 * @return status success/failure
	 * 
	 * 
	 */
	public boolean changePassword(String userId, String newPassword) throws UserNotFoundException;
	
	/**
	 * Method to get role of a specific User
	 * @param userId
	 * @throws UserNotFoundException
	 * @return Role of the User
	 */
    public String getRole(String userId) throws UserNotFoundException;
}
