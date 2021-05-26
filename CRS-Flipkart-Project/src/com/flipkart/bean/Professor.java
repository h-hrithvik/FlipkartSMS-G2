/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-02
 * Professor Class to implement Professor
 */
public class Professor extends User {

	private String professorId;
	private String department;

	/**
	 * Constructor to instantiate professor object
	 * @param userName
	 * @param phoneNumber
	 * @param address
	 * @param userId
	 * @param userPassword
	 * @param type
	 * @param professorId
	 * @param department
	 */
	public Professor(String userName, String phoneNumber, String address, String userId, String userPassword,
			String type, String professorId, String department) {
		super(userName, phoneNumber, address, userId, userPassword, type);
		this.professorId = professorId;
		this.department = department;
	}

	/**
	 * Getters Setters for Professor details
	 *
	 */
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

	/**
	 * Method to Convert professor Id to string
	 * @return ID as string value
	 */
	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", department=" + department + "]";
	}

}
