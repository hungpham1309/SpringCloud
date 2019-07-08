package com.example.bookservice.service;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    DataSource dataSource;

    public List<Book> getAllBooks() {
        return bookRepository.getAllBook();
    }


    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(int id, Book book) {
        Book bookUpdate = bookRepository.findById(id);
        if (bookUpdate != null) {
            bookUpdate.setAuthor(book.getAuthor());
            bookUpdate.setTitle(book.getTitle());
        }
        return bookRepository.save(bookUpdate);
    }

    public void removeBook(int id) {
        bookRepository.deleteById(id);
    }
}
