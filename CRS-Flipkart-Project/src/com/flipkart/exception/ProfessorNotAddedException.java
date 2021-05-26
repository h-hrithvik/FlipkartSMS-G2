package com.flipkart.exception;

/**
 * Exception to check if the professor is not added successfully by admin
 * 
 * @author JEDI-02
 *
 */
public class ProfessorNotAddedException extends Exception {
	private String professorId;

	public ProfessorNotAddedException(String professorId) {
		this.professorId = professorId;
	}

	/**
	 * Message returned when exception is thrown
	 * 
	 * @return string: error message
	 */
	@Override
	public String getMessage() {
		return "professorId: " + professorId + " not added!";
	}
}
