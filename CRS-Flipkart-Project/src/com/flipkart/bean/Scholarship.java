/**
 * 
 */
package com.flipkart.bean;

/**
 * @author hp
 *
 */
public class Scholarship extends Payment{

	private String scholarId ;
	private float scholarAmount;
	
	public String getScholarId() {
		return scholarId;
	}
	public void setScholarId(String scholarId) {
		this.scholarId = scholarId;
	}
	public float getScholarAmount() {
		return scholarAmount;
	}
	public void setScholarAmount(float scholarAmount) {
		this.scholarAmount = scholarAmount;
	}
}
