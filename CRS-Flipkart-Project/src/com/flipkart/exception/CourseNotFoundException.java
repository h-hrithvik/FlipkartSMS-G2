/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-02
 * Exception to check if course exists.
 */
public class CourseNotFoundException extends Exception {
 
	// Course Code which cannot be found.
	private String courseCode;
	
	public CourseNotFoundException(String courseCode)
	{	
		this.courseCode = courseCode;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseCode + " not found.";
	}

}
