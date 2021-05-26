/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-02
 * Notification Class
 */
public class Notification {

	private String notificationId;
	private String message;
	private String paymentId;
	private String studentId;

	/**
	 * Constructor Classes to instantiate Notification Class
	 */
	public Notification() {
		super();
	}

	public Notification(String notificationId, String message, String paymentId, String studentId) {
		super();
		this.notificationId = notificationId;
		this.message = message;
		this.paymentId = paymentId;
		this.studentId = studentId;
	}

	/**
	 * Getters Setters for Notification details
	 */
	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

}
