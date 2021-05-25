package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotFoundException;

public class UserOperation implements UserInterface {

	@Override
	public boolean addUser(User user) throws UserAlreadyExistException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyCredentials(String userId, String userPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(String userId, String newPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
