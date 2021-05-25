/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Jedi-03
 *
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
