package com.riya.api.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riya.api.library.entity.Publisher;

public interface PublisherDao extends JpaRepository<Publisher,Integer> {
	
}
