/**
 * 
 */
package com.flipkart.exception;

/**
 * @author lenovo
 *
 */
public class CourseNotDeletedException extends Exception {

	/*
	 * Course Code which cannot be Deleted.
	 * */
	private String courseCode;


	public CourseNotDeletedException(String courseCode)
	{	
		this.courseCode = courseCode;
	}
	
	
	/*
	 * Setter for courseCode.
	 * */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	
	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseCode + " can not be deleted.";
	}
}
