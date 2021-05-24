/**
 * 
 */
package com.flipkart.bean;

/**
 * @author WIN 10
 *
 */
public class Professor extends User{

	private String professorId;
	private String department;
	
	public String getProfessorId() {
		return professorId;
	}
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
