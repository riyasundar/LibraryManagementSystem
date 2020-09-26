package com.riya.api.library.service;

import java.util.List;

import com.riya.api.library.entity.Book;

public interface LibraryService {

	public Book save(Book book);

	public List<Book> getBooks();

	public Book getByUser(int userId);

	public Book update(Book book);
	
	public int delete(int id);
}
