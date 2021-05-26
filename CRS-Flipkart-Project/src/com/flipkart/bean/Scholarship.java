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

	public Scholarship(String paymentId, String studentId, int amount, String status, String notificationId,
			int semester) {
		super(paymentId, studentId, amount, status, notificationId, semester);
		// TODO Auto-generated constructor stub
	}
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
