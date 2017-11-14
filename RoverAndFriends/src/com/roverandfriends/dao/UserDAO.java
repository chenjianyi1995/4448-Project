package com.roverandfriends.dao;



import java.util.List;

import com.roverandfriends.model.User;



public interface UserDAO {
	public abstract boolean saveUser(User user);
	public abstract boolean deleteUser(User user);
	public User getUserDetailsByEmailAndPassword(String email,String password);
	public List<User> getUserList();
	void updateUserDogSitterStatus(User user);
	public abstract List<User> getDogSitterList();
	
}
