/**
 * 
 */
package com.flipkart.bean;

/**
 * @author WIN 10
 *
 */
public class Professor extends User {

	private String professorId;
	private String department;

	public Professor(String userName, String phoneNumber, String address, String userId, String userPassword,
			String type, String professorId, String department) {
		super(userName, phoneNumber, address, userId, userPassword, type);
		this.professorId = professorId;
		this.department = department;
	}
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

	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", department=" + department + "]";
	}

}
