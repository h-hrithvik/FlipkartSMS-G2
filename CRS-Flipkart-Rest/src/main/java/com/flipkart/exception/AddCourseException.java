/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-02 Exception to check if the course is available for adding.
 */
public class AddCourseException extends Exception {
	private String courseId;

	/***
	 * Constructor
	 * 
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
