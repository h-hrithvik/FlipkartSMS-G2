/**
 * 
 */
package com.flipkart.exception;


public class UserNotApprovedExecption extends Exception{
	private String userId;

	/***
	 * Constructor function for UserId
	 * @param userId
	 */
	
	public UserNotApprovedExecption(String userId) {
		super();
		this.userId = userId;
	}
	
	@Override
	public String getMessage() {
		return "This User " + userId + " is not approved";
	}
	
}
