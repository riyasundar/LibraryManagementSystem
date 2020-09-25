package com.riya.api.library.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riya.api.library.entity.Book;
import com.riya.api.library.service.LibraryService;

@RestController
@RequestMapping("/api")
public class LibraryRestController {

	@Autowired
	private LibraryService service;
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book theBook = service.save(book);
		return theBook;
	}
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book book) {
		Book theBook = service.update(book);
		return theBook;
	}
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		List<Book> books = service.getBooks();
		return books;
	}
	
	@GetMapping("/books/{userId}")
	public Book getBook(@PathVariable int userId) {
		System.out.print(userId);
		Book book = service.getByUser(1);
		return book;
	}
}
