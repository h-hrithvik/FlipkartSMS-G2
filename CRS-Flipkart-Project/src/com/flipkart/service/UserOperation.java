package com.flipkart.service;

import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.UserNotFoundException;

public class UserOperation implements UserInterface {

	@Override
	public boolean verifyCredentials(String userId, String userPassword) throws UserNotFoundException {
		UserDaoOperation obj = new UserDaoOperation();
		return obj.updatePassword(userId, userPassword);
	}
 
	@Override
	public boolean changePassword(String userId, String newPassword) throws UserNotFoundException {
		UserDaoOperation obj = new UserDaoOperation();
		return obj.updatePassword(userId, newPassword);
	}

	@Override
	public String getRole(String userId) throws UserNotFoundException {
		UserDaoOperation obj = new UserDaoOperation();
		return obj.getRole(userId);
	}

}
