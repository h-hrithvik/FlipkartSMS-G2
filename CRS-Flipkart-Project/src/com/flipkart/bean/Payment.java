/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-02
 * Payment Class
 */
public class Payment {
	private String paymentId;
	private String studentId;
	private float amount;
	private boolean status;

	/**
	 * Getters Setters for Payment details
	 *
	 */
	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
