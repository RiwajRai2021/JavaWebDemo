package com.service;

import java.util.List;

import com.model.User;

public interface userService {
	
	void userSignup(User user);
	boolean userLogin(String un, String psw);
	List<User> getAllUsers();
	
	

}
