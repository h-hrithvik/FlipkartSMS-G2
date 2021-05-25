/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-02
 * Exception to check if the course is already registered.
 */
public class CourseAlreadyRegisteredException extends Exception{
	
	private String courseId;
	
	/***
	 * Constructor
	 * @param courseId
	 */
	public CourseAlreadyRegisteredException(String courseId) {
		this.courseId = courseId;
	}
	
	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "You have already registered for " + courseId;
	}

}
