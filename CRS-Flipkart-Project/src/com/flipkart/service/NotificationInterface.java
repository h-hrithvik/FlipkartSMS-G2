/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Notification;

/**
 * @author lenovo
 *
 */
public interface NotificationInterface {
	
	
	public int sendNotification(Notification notification , int studentId);
	
	public Notification generateNotifications(String message , String paymentId,String studentId);
}
