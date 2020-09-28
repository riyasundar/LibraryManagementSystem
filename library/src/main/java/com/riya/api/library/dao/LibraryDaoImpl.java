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
		return book;
	}

	@Override
	@Transactional
	public Book update(Book book) {
		Session currentSession = entity.unwrap(Session.class);
		currentSession.saveOrUpdate(book);
		return book;
	}
	@Override
	@Transactional
	public int delete(int id) {
		Session currentSession = entity.unwrap(Session.class);
		Book book = currentSession.get(Book.class, id);
		currentSession.delete(book);
		return id;
	}

	@Override
	public List<Book> search(String searchBy, String searchText) {
		String sqlString = "";
		Session currentSession = entity.unwrap(Session.class);
		if(searchText.equals("empty")) {
			sqlString = "from Book";
		}else {
		if(searchBy.equalsIgnoreCase("book")){
			sqlString = "from Book where bookname =:searchText";
		}else if(searchBy.equals("category")) {
			sqlString = "from Book where category =:searchText";
		}else if(searchBy.equals("author")) {
			sqlString = "from Book where author =:searchText";
		}else if(searchBy.equals("publisher")) {
			sqlString = "from Book where publisher =:searchText";
		}
		}
		Query<Book> getQuery = currentSession.createQuery(sqlString,Book.class);
		if(!searchText.equals("empty")) {
			getQuery.setParameter("searchText", searchText);
		}
		List<Book> book = getQuery.getResultList();
		return book;
	}

}
