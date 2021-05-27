package com.flipkart.constant;

/**
 *
 * @author JEDI-02
 *
 */
public enum ModeOfPaymentConstants {

    CREDIT_CARD,NET_BANKING,DEBIT_CARD;

    /**
     * Method to get ModeOfPayment from int
     * @param value
     * @return
     */
    public static ModeOfPaymentConstants getModeofPayment(int value)
    {
        switch(value)
        {
            case 1:
                return ModeOfPaymentConstants.CREDIT_CARD;
            case 2:
                return ModeOfPaymentConstants.NET_BANKING;
            case 3:
                return ModeOfPaymentConstants.DEBIT_CARD;
            default:
                return null;

        }

    }

}