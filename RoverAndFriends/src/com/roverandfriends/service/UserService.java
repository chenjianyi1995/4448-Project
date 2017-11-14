package com.roverandfriends.service;



import java.util.List;

import com.roverandfriends.model.User;

public interface UserService {
	public abstract User validateUserCredential(String email,	String password);
	public abstract boolean registerUser(User user);
	public abstract boolean unregisterUser(User user);
	public abstract List<User> getUserList();
	public abstract String getUserName(User user);
	public abstract void updateUserDogSitterStatusToTrue(User user);
	public abstract void updateUserDogSitterStatusToFalse(User user);
	public abstract List<User> getDogSitters();


	

}