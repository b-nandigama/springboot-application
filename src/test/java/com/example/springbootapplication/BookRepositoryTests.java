package com.example.springbootapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.springbootapplication.entity.Book;
import com.example.springbootapplication.repository.BookRepository;

@DataJpaTest
public class BookRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void whenFindbyTitle_thenReturnBook() {
		//given
		Book book = new Book("Welcome To Java", "Bala Nandigama");
		entityManager.persist(book);
		entityManager.flush();
		
		//when
		List<Book> found = bookRepository.findByTitle("Welcome To Java");
		
		//then
		assertEquals(found.get(0).getAuthor(), "Bala Nandigama");
		
	}
}
