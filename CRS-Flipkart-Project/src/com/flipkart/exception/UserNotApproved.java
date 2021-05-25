/**
 * 
 */
package com.flipkart.exception;


public class UserNotApproved extends Exception{
	private String userId;

	/***
	 * Constructor function for UserId
	 * @param userId
	 */
	
	public UserNotApproved(String userId) {
		super();
		this.userId = userId;
	}
	
	@Override
	public String getMessage() {
		return "This User " + userId + " is not approved";
	}
	
}
