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

import com.riya.api.library.dao.PublisherDao;
import com.riya.api.library.entity.Publisher;

@RestController
@RequestMapping("/api")
public class PublisherRestController {

	@Autowired
	private PublisherDao dao;
	
	@GetMapping("/publishers")
	public List<Publisher> getPublisher(){
		List<Publisher> publishers = dao.findAll();
		return publishers;
	}
	
	@GetMapping("/publishers/{id}")
	public Publisher getAuthor(@PathVariable int id){
		Publisher thePublisher = null;
		Optional<Publisher> publisher = dao.findById(id);
		if(publisher.isPresent()) {
			thePublisher = publisher.get();
		}
		return thePublisher;
	}
	
	@PostMapping("/publishers")
	public Publisher addAuthor(@RequestBody Publisher publisher){
		dao.save(publisher);
		return publisher;
	}
	
	@PutMapping("/publishers")
	public Publisher updateAuthor(@RequestBody Publisher publisher){
		dao.save(publisher);
		return publisher;
	}
	
	@DeleteMapping("/publishers/{id}")
	public int deleteAuthor(@PathVariable int id){
		dao.deleteById(id);
		return id;
	}
	
	
	
}
