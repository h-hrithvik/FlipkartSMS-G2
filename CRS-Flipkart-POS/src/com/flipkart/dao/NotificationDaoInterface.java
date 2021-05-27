package com.flipkart.dao;

import java.sql.SQLException;
import java.util.UUID;

import com.flipkart.constant.ModeOfPaymentConstants;
import com.flipkart.constant.NotificationTypeConstants;

/**
 *
 * @author JEDI-02
 * used for adding the notification to the database
 *
 */
public interface NotificationDaoInterface {
    /**
     *
     * @param type: type of the notification to be sent
     * @param studentId: student to be notified
     * @return notification id for the record added in the database
     */
    public int sendNotification(NotificationTypeConstants type,int studentId,ModeOfPaymentConstants modeOfPayment) throws SQLException;
}