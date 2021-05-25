/**
 * 
 */
package com.flipkart.exception;


public class UserNotFound extends Exception{
	private String userId;
	
	/***
	 * Constructor function for UserId
	 * @param userId
	 */
	public UserNotFound(String userId) {
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
