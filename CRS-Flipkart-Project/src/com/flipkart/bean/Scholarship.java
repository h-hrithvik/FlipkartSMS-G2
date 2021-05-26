/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-02
 * Scholarsihp Class
 */
public class Scholarship extends Payment {

	private String scholarId;
	private float scholarAmount;

	/**
	 * Getter Setter Methods for Scholarship details
	 *
	 */
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
