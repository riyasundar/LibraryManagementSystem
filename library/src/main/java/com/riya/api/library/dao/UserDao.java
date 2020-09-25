package com.riya.api.library.dao;

import com.riya.api.library.entity.User;

public interface UserDao {

	public String checkUser(String user, String password);
	
	public User registerUser(User user);

	public String checkUser(String user);

	
}
