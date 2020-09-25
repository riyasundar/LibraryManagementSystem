package com.riya.api.library.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riya.api.library.dao.AuthorDao;
import com.riya.api.library.entity.Author;

@RestController
@RequestMapping("/api")
public class AuthorRestController {

	@Autowired
	private AuthorDao dao;
	
	@GetMapping("/author")
	public List<Author> getAuthor(){
		List<Author> authors = dao.findAll();
		return authors;
	}
	
	@GetMapping("/author/{id}")
	public Author getAuthor(@PathVariable int id){
		Author theAuthor = null;
		Optional<Author> author = dao.findById(id);
		if(author.isPresent()) {
			theAuthor = author.get();
		}
		return theAuthor;
	}
	
	@PostMapping("/author")
	public Author addAuthor(@RequestBody Author author){
		dao.save(author);
		return author;
	}
	
	@PutMapping("/author")
	public Author updateAuthor(@RequestBody Author author){
		dao.save(author);
		return author;
	}
	
	@DeleteMapping("/author/{id}")
	public int deleteAuthor(@PathVariable int id){
		dao.deleteById(id);
		return id;
	}
	
	
	
}
