/**
 * 
 */
package com.flipkart.exception;

/**
 * @author lenovo
 *
 */
public class CourseNotAssignedToProfessorException extends Exception {
	
	/*
	 * @courseCode is not assigned to professor with @professorId.
	 * */
	private String courseCode;
	private String professorId;
	
	public CourseNotAssignedToProfessorException(String courseCode, String professorId) {
		this.courseCode = courseCode;
		this.professorId = professorId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "courseCode: " + courseCode + " OR professorId: " + professorId + " does not exist!";
	}
}
