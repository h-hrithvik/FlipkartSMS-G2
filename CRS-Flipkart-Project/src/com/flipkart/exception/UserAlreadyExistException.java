/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-02 Exception to check if the user already exists in the system.
 */

public class UserAlreadyExistException extends Exception {
	private String userId;

	/***
	 * Constructor function for UserId
	 * 
	 * @param userId
	 */

	public UserAlreadyExistException(String userId) {
		super();
		this.userId = userId;
	}

	@Override
	public String getMessage() {
		return "userId: " + userId + " already exist";
	}
}
