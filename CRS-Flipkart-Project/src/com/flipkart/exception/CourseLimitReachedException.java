/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Jedi-03
 *
 */
public class CourseLimitReachedException extends Exception{
	
	private int coursesRegisterd;

	/**
	 * Constructor
	 * @param coursesRegisterd number of courses registered
 	 */
	public CourseLimitReachedException(int coursesRegisterd)
	{	
		this.coursesRegisterd = coursesRegisterd;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() 
	{
		return "You have already registered for " + coursesRegisterd + " courses";
	}


}