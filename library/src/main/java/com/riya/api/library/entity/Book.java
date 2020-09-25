package com.riya.api.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookid")
	private int bookid;
	
	@Column(name="bookname")
	private String bookname;
	
	@Column(name="category")
	private String category;
	
	@Column(name="author")
	private String author;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="rent_user")
	private String rentUser;

	public Book() {
		
	}
	
	public Book(String bookname,String category, String author, String publisher, String rentUser) {
		this.bookname = bookname;
		this.category=category;
		this.author = author;
		this.publisher = publisher;
		this.rentUser = rentUser;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getRentUser() {
		return rentUser;
	}

	public void setRentUser(String rentUser) {
		this.rentUser = rentUser;
	}

}
