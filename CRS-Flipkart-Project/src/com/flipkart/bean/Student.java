/**
 * 
 */
package com.flipkart.bean;

/**
 * @author naman
 *
 */
public class Student extends User{
	
	private String rollNumber;
	private String branch;
	private Boolean isVerified;
	

	public Student(String userName, String phoneNumber, String address, String userId, String userPassword, String type,
			String rollNumber, String branch, Boolean isVerified) {
		super(userName, phoneNumber, address, userId, userPassword, type);
		this.rollNumber = rollNumber;
		this.branch = branch;
		this.isVerified = isVerified;
	}

	public String getRollNumber() {
		return rollNumber;
	}	
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
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
		return "Student [rollNumber=" + rollNumber + ", branch=" + branch + ", isVerified=" + isVerified + "]";
	}
	
}
