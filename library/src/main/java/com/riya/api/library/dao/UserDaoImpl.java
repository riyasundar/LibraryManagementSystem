package com.riya.api.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riya.api.library.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entity;
	
	@Override
	public String checkUser(String user, String password) {
		try {
		Session currentSession = entity.unwrap(Session.class);
		Query<User> checkQuery = currentSession.createQuery("from User where username=:user"
				+ " and password=:password",
				User.class);
		checkQuery.setParameter("user", user);
		checkQuery.setParameter("password", password);
		checkQuery.getSingleResult();
		return "Present";
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public User registerUser(User user) {
		Session currentSession = entity.unwrap(Session.class);
		currentSession.save(user);
		return user;
	}

	@Override
	public String checkUser(String user) {
		try {
		Session currentSession = entity.unwrap(Session.class);
		Query<User> checkQuery = currentSession.createQuery("from User where username=:user",
				User.class);
		checkQuery.setParameter("user", user);
		checkQuery.getResultList();
		return "Present";
		}catch(NoResultException e) {
			return null;
		}
	}

}
