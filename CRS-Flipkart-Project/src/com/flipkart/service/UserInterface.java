package com.flipkart.service;

import com.flipkart.bean.User;

public interface UserInterface {
	public boolean addUser(User user);
	
	public boolean verifyCredentials(String userId, String userPassword);
	
	public boolean changePassword(String userId,String newPassword);
}
