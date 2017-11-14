package com.roverandfriends.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roverandfriends.dao.UserDAO;
import com.roverandfriends.model.User;
import com.roverandfriends.service.UserService;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	

	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public String getUserName(User user) {
		return user.getUserName();
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Override
	public List<User> getUserList(){
		return userDAO.getUserList();
	}
	
	@Override
	public boolean registerUser(User user) {
		boolean isRegister=false;
		boolean saveUser = getUserDAO().saveUser(user);
		if(saveUser)
			isRegister=true;
		return isRegister;
	}

	@Override
	public boolean unregisterUser(User user) {
		boolean isRegister=false;
		boolean deleteUser = getUserDAO().deleteUser(user);
		if(deleteUser)
			isRegister=true;
		return isRegister;
	}

	
	@Override
	public User validateUserCredential(String email, String password) {
		User user = getUserDAO().getUserDetailsByEmailAndPassword(email, password);
		return user;
	}

	
	@Override
	@Transactional
	public void updateUserDogSitterStatusToTrue(User user) {
		user.setDogSitter(true);
		userDAO.updateUserDogSitterStatus(user);
		
	}
	

	@Override
	@Transactional
	public void updateUserDogSitterStatusToFalse(User user) {
		user.setDogSitter(false);
		userDAO.updateUserDogSitterStatus(user);
		
	}

	@Override
	public List<User> getDogSitters() {
		return userDAO.getDogSitterList();
	}


	

	
}
