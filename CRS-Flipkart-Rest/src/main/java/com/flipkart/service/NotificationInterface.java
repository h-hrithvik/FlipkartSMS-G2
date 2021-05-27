/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Notification;

/**
 * @author JEDI-02
 *
 */
public interface NotificationInterface {

	/**
	 * Function to send notification to student
	 * 
	 * @param notification
	 * @param studentId
	 * @return if the notification is sent
	 */
	public boolean sendNotification(Notification notification, int studentId);

	/**
	 * Function to create notification
	 * 
	 * @param message
	 * @param paymentId
	 * @param studentId
	 * @return notification generated
	 */
	public Notification generateNotifications(String message, String paymentId, String studentId);
}
