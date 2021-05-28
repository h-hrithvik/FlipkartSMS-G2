/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-02
 * Scholarsihp Class
 */
public class Student extends User {

	private String studentId;
	private String branch;
	private Boolean isVerified;

	public Student() {
		
	}
	/**
	 * Constructor for student object
	 * @param userName
	 * @param phoneNumber
	 * @param address
	 * @param userId
	 * @param userPassword
	 * @param type
	 * @param rollNumber
	 * @param branch
	 * @param isVerified
	 */
	public Student(String userName, String phoneNumber, String address, String userId, String userPassword, String type,
			String rollNumber, String branch, Boolean isVerified) {
		super(userName, phoneNumber, address, userId, userPassword, type);
		this.studentId = rollNumber;
		this.branch = branch;
		this.isVerified = isVerified;
	}

	/**
	 * Getter Setter Methods for Student details
	 *
	 */
	public String getRollNumber() {
		return studentId;
	}

	public void setRollNumber(String rollNumber) {
		this.studentId = rollNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	/**
	 * Method to Convert Student object to string
	 * @return object as string value
	 */
	@Override
	public String toString() {
		return "Student [rollNumber=" + studentId + ", branch=" + branch + ", isVerified=" + isVerified + "]";
	}

}
