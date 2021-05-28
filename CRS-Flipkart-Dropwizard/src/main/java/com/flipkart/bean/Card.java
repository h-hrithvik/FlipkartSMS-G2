/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-02
 *	Card Class
 */
public class Card {

	private String cardNumber;
	private String cardType;
	private String bankName;
	private String IFSCcode;

	/**
	 * Getters Setters Methods for the class
	 *
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIFSCcode() {
		return IFSCcode;
	}

	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}
}
