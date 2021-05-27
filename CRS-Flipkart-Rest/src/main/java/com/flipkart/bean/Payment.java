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
	private int amount;

	private String status;
	public String getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getStatus() {
		return status;
	}

	private String notificationId;
	private int semester;

	/**
	 * Getters Setters for Payment details
	 *
	 */
	
	public Payment(String paymentId, String studentId, int amount, String status, String notificationId,
			int semester) {
		super();
		this.paymentId = paymentId;
		this.studentId = studentId;
		this.amount = amount;
		this.status = status;
		this.notificationId = notificationId;
		this.semester = semester;
	}
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
