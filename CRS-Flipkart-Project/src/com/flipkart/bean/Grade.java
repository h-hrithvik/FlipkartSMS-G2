/**
 * 
 */
package com.flipkart.bean;

/**
 * @author naman
 *
 */
public class Grade {
	private String studentId;
	private int sem;
	private String grade;
	
	public Grade(String studentId, int sem, String grade) {
		super();
		this.studentId = studentId;
		this.sem = sem;
		this.grade = grade;
	}

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
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
