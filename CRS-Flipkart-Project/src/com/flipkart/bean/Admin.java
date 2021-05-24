package com.flipkart.bean;

public class Admin extends User{

	private String adminId;
	
	public Admin(String userName, String phoneNumber, String address, String userId, String userPassword, String type,
			String adminId) {
		super(userName, phoneNumber, address, userId, userPassword, type);
		this.adminId = adminId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "]";
	}

}
