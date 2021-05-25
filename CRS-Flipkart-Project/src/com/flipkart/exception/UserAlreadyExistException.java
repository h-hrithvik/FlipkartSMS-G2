/**
 * 
 */
package com.flipkart.exception;


public class UserAlreadyExistException extends Exception{
	private String userId;

	/***
	 * Constructor function for UserId
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
