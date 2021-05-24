package com.flipkart.bean;

public class Cheque extends Payment {
	private String bankName;
	private String chequeNumber;
	private String holderName;
	
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getChequeNumber() {
		return chequeNumber;
	}
	
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
	public String getHolderName() {
		return holderName;
	}
	
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

}
