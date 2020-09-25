package com.riya.api.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riya.api.library.dao.UserDao;
import com.riya.api.library.entity.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	UserDao dao;
	
	@GetMapping("/user/{username}")
	public String checkUser(@PathVariable String username) {
		String result = dao.checkUser(username);
		return result;
	}
	
	@PostMapping("/user")
	public User registerUser(@RequestBody User theuser) {
		User user = dao.registerUser(theuser);
		return user;
	}
}
