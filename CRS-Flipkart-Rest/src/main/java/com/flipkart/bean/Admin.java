package com.flipkart.bean;
/**
 *
 * @author JEDI-02
 * Admin Class
 *
 */
public class Admin extends User {

	private String adminId;

	public Admin(String userName, String phoneNumber, String address, String userId, String userPassword, String type,
			String adminId) {
		super(userName, phoneNumber, address, userId, userPassword, type);
		this.adminId = adminId;
	}

	/**
	 * Setter Getter for adminId
	 *
	 */

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	/**
	 * function to convert id to string.
	 * @return
	 */
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "]";
	}

}
