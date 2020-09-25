package com.riya.api.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riya.api.library.entity.Author;

public interface AuthorDao extends JpaRepository<Author,Integer> {
	
}
