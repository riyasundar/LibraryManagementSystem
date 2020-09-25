package com.riya.api.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="authorid")
	private int authorId;
	
	@Column(name="authorname")
	private String authorname;

	@Transient
	@Column(name="bookid")
	private int bookid;
	
	public Author() {
		
	}
	public Author(String authorName,int bookid) {
		this.authorname = authorName;
	}

	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorname;
	}

	public void setAuthorName(String authorName) {
		this.authorname = authorName;
	}
	
}
