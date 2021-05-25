package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {
	/**
	 * Function to add new user to system
	 * 
	 * @param user
	 * @throws UserAlreadyExistException
	 * @return status if the user is created or not
	 */
	public boolean addUser(User user) throws UserAlreadyExistException;

	/**
	 * Function to verify credentials while login
	 * 
	 * @param userId
	 * @param userPassword
	 * @throws UserNotFoundException
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
}
