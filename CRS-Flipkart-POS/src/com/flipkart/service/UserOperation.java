package com.flipkart.service;

import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.UserNotFoundException;

public class UserOperation implements UserInterface {
	private static volatile UserOperation instance=null;
	UserDaoInterface userDaoInterface= UserDaoOperation.getInstance();

	/**
	 * Method to make UserOperation Singleton
	 * @return
	 */
	public static UserOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(UserOperation.class){
				instance=new UserOperation();
			}
		}
		return instance;
	}


	@Override
	public boolean verifyCredentials(String userId, String userPassword) throws UserNotFoundException {
		return userDaoInterface.verifyCredentials(userId, userPassword);
	}

	@Override
	public boolean changePassword(String userId, String newPassword) throws UserNotFoundException {
		return userDaoInterface.updatePassword(userId, newPassword);
	}


	@Override
	public String getRole(String userId) throws UserNotFoundException {
		return userDaoInterface.getRole(userId);
	}

}
