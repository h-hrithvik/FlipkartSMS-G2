/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-02 Exception to check if the user exists in the system.
 */

public class UserNotFoundException extends Exception {
	private String userId;

	/***
	 * Constructor function for UserId
	 * 
	 * @param userId
	 */
	public UserNotFoundException(String userId) {
		super();
		this.userId = userId;
	}

	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "User with userId: " + userId + " does not exist";
	}

}
