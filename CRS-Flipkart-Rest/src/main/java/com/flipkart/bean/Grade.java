/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-02
 * Grade Class
 */
public class Grade {
	private String studentId;
	private int semester;
	private String grade;

	/**
	 * Constructor to instantiate Grade Class
	 * @param studentId
	 * @param sem
	 * @param grade
	 */
	public Grade(String studentId, int sem, String grade) {
		super();
		this.studentId = studentId;
		this.semester = sem;
		this.grade = grade;
	}

	/**
	 * Getters Setters for Grade properties
	 */

	public Grade() {
		super();
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getSem() {
		return semester;
	}

	public void setSem(int sem) {
		this.semester = sem;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
