package com.example.springbootapplication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootapplication.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findByTitle(String title); 
}
