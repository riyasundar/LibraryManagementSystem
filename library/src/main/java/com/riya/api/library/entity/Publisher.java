package com.riya.api.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="publisher_id")
	private int publisherId;
	
	@Column(name="publisher_name")
	private String publisherName;
	
	@Column(name="bookid")
	private String bookid;

	public Publisher() {
		
	}
	public Publisher(String publisherName, String bookid) {
		this.publisherName = publisherName;
		this.bookid = bookid;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	
	
	
}
