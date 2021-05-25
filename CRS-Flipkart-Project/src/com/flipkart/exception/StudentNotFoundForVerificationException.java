/**
 * 
 */
package com.flipkart.exception;

/**
 * @author lenovo
 *
 */
public class StudentNotFoundForVerificationException extends Exception {
    
	/*
	 * @studentId not found for verification.
	 * */
	private String studentId;
	
	public StudentNotFoundForVerificationException(String studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "studentId: " + studentId + " not found for approval!" ;
	}
}
