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
	
}
