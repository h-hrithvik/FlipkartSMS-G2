/**
 * 
 */
package com.flipkart.bean;

/**
 * @author naman
 *
 */
public class Student extends User{
	
	private String studentId;
	private String branch;
	private Boolean isVerified;
	

	public Student(String userName, String phoneNumber, String address, String userId, String userPassword, String type,
			String rollNumber, String branch, Boolean isVerified) {
		super(userName, phoneNumber, address, userId, userPassword, type);
		this.studentId = rollNumber;
		this.branch = branch;
		this.isVerified = isVerified;
	}

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
	
	@Override
	public String toString() {
		return "Student [rollNumber=" + studentId + ", branch=" + branch + ", isVerified=" + isVerified + "]";
	}
	
}
