package com.flipkart.exception;

/**
 * Exception to check if student has been allotted grade by professor
 * 
 * @author JEDI-02
 *
 */
public class GradeNotAddedException extends Exception {

	private String studentId;

	/**
	 * Constructor
	 * 
	 * @param studentId
	 */
	public GradeNotAddedException(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * Message returned when exception is thrown
	 * 
	 * @return string: error message
	 */
	@Override
	public String getMessage() {
		return "Grade not allotted yet to: " + studentId;
	}

}