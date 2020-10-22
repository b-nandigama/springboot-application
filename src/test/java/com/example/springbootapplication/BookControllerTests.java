package com.example.springbootapplication;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.springbootapplication.controller.BookController;
import com.example.springbootapplication.entity.Book;
import com.example.springbootapplication.repository.BookRepository;

@WebMvcTest(controllers = {BookController.class})
public class BookControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookController bookController;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@IgnoreForBinding
	public void givenBooks_whenGetBooks_thenReturnJsonArray() throws Exception {
		Book book = new Book("Java Programming", "James Gosling");
		
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		
		mockMvc.perform(MockMvcRequestBuilders.get("")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	@Test
	public void whenGetAllBooks_thenOK() {
	Book book = new Book();
	book.setId(1);
	book.setTitle("Java Programming");
	book.setAuthor("James Saranchik");
		
	List<Book> list = new ArrayList<Book>();
	list.add(book);
	
	Mockito.when(bookRepository.findAll()).thenReturn(list);
	List<Book> books = (List<Book>) bookController.findAll();
	assertTrue(books.size() > 0);
	}
	
}
