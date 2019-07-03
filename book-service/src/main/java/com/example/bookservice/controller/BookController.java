package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.service.BookService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping(value = "/books")
	public List<Book> getBook() {
		return bookService.getAllBooks();
	}

	@GetMapping(value = "/book/{id}")
	public Book getBookById(@PathVariable int id) {
		return bookService.getBookById(id);
	}

	@PostMapping(value = "/book")
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

	@PatchMapping(value = "book/{id}")
	public Book updateBook(@PathVariable int id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@DeleteMapping(value = "book/{id}")
	public void removeBook(@PathVariable int id) {
		bookService.removeBook(id);
	}
}
