/**
 * 
 */
package com.flipkart.exception;

/**
 * @author lenovo
 *
 */
public class PaymentNotFoundException extends Exception {
	
	/*
	 * @paymentId which is not found
	 * */
	private String paymentId;
	
	public PaymentNotFoundException(String id) {
		this.paymentId = id;
	}
	
	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "paymentId: " + paymentId + " not found!" ;
	}

}
