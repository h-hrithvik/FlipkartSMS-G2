/**
 * 
 */
package com.flipkart.exception;


public class UserAlreadyExist extends Exception{
	private String userId;

	/***
	 * Constructor function for UserId
	 * @param userId
	 */
	
	public UserAlreadyExist(String userId) {
		super();
		this.userId = userId;
	}
	
	@Override
	public String getMessage() {
		return "userId: " + userId + " already exist";
	}
}
