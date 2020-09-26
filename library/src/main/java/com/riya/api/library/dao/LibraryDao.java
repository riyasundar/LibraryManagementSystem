package com.riya.api.library.dao;

import java.util.List;

import com.riya.api.library.entity.Book;

public interface LibraryDao {

	public Book save(Book book);

	public List<Book> getAll();

	public Book getByUser(int userId);

	public Book update(Book book);
	
	public int delete(int id);
}
