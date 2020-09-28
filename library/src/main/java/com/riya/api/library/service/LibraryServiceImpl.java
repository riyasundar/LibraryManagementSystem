package com.riya.api.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riya.api.library.dao.LibraryDao;
import com.riya.api.library.entity.Book;

@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryDao dao;
	
	@Override
	public Book save(Book book) {
		Book theBook = dao.save(book);
		return theBook;
	}

	@Override
	public List<Book> getBooks() {
		List<Book> books = dao.getAll();
		return books;
	}

	@Override
	public Book getByUser(int userId) {
		Book book = dao.getByUser(userId);
		return book;
	}

	@Override
	public Book update(Book book) {
		Book theBook = dao.update(book);
		return theBook;
	}

	@Override
	public int delete(int id) {
		int returnId = dao.delete(id);
		return returnId;
	}

	@Override
	public List<Book> search(String searchBy, String searchText) {
		List<Book> books = dao.search(searchBy,searchText);
		return books;
	}

}
