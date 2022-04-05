package com.example.bookservice.services;

import com.example.bookservice.models.Book;
import com.example.bookservice.repos.BookRepository;
import com.example.bookservice.services.metrics.BookMetricService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final BookMetricService bookMetricService;

    public List<Book> getAllBooks() {
        log.debug("get all books called");
        bookMetricService.processReceived();
        return bookRepository.findAll();
    }

    public Book createBook(Book newBook) {
        Book createdBook = bookRepository.save(newBook);
        bookMetricService.processCreation(createdBook);
        log.debug("book created: " + newBook);
        return createdBook;
    }
}
