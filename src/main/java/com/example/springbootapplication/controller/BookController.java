package com.example.springbootapplication.controller;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapplication.entity.Book;
import com.example.springbootapplication.exception.BookIdMismatchException;
import com.example.springbootapplication.exception.BookNotFoundException;
import com.example.springbootapplication.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping
	public Iterable findAll() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/title/{title}")
	public List<Book> findByTitle(@PathVariable("title") String title) {
		return bookRepository.findByTitle(title);
	}
	
	@GetMapping("/{id}")
	public Book findByOne(@PathVariable("id") Long id) {
		return bookRepository.findById(id)
				.orElseThrow(BookNotFoundException::new);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		bookRepository.findById(id)
					.orElseThrow(BookNotFoundException::new);
		bookRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Book update(@RequestBody Book book, @PathVariable long id) {
		if(book.getId() != id) {
			throw new BookIdMismatchException();
		}
		bookRepository.findById(id)
				.orElseThrow(BookNotFoundException::new);
		return bookRepository.save(book);
		
	}
}
