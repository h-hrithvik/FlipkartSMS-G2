/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Jedi-03
 *
 */
public class AddCourseException extends Exception{
	private String courseId;
	
	/***
	 * Constructor
	 * @param courseId
	 */
	public AddCourseException(String courseCode) {
		this.courseId = courseId;
	}
	
	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Course with courseId " + courseId + " already exist in catalog.";
	}
}
