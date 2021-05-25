/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-02
 * Exception to check if the student exists in the system for verification.
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
