package com.riya.api.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riya.api.library.entity.Book;

@Repository
public class LibraryDaoImpl implements LibraryDao {

	private EntityManager entity;
	
	@Autowired
	public LibraryDaoImpl(EntityManager theEntityManager) {
		entity = theEntityManager;
	}
	
	@Override
	@Transactional
	public Book save(Book book) {
		Session currentSession = entity.unwrap(Session.class);
		currentSession.saveOrUpdate(book);
		return book;
	}

	@Override
	public List<Book> getAll() {
		Session currentSession = entity.unwrap(Session.class);
		Query<Book> getQuery = currentSession.createQuery("from Book",Book.class);
		List<Book> books = getQuery.getResultList();
		return books;
	}

	@Override
	@Transactional
	public Book getByUser(int id) {
		Session currentSession = entity.unwrap(Session.class);
		Query<Book> getQuery = currentSession.createQuery("from Book where bookid=:bookid",Book.class);
		getQuery.setParameter("bookid", id);
		Book book = getQuery.getSingleResult();
//		Book book = currentSession.get(Book.class, userId);
		return book;
	}

	@Override
	@Transactional
	public Book update(Book book) {
		Session currentSession = entity.unwrap(Session.class);
		Book theBook = currentSession.get(Book.class, book.getBookid());
		theBook.setRentUser(book.getRentUser());
		currentSession.saveOrUpdate(book);
		return book;
	}


}
