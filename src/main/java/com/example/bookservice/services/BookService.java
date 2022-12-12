package com.example.bookservice.services;

import com.example.bookservice.models.Book;
import com.example.bookservice.repos.BookRepository;
import com.example.bookservice.services.metrics.BookMetricService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Optional<Book> findBook(Long bookId) {
        log.debug("find book with id: " + bookId);
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()) {
            log.debug("found book: " + book);
        } else {
            log.debug("book with id " + bookId + "couldn't be found");
        }
        return book;
    }

    public Book createBook(Book newBook) {
        Book createdBook = bookRepository.save(newBook);
        bookMetricService.processCreation(createdBook);
        log.debug("book created: " + newBook);
        return createdBook;
    }

    public Book deleteBookById(Long bookId) throws NoSuchElementException {
        log.debug("delete book with id: " + bookId);
        Book book = bookRepository.findById(bookId).orElseThrow();
        bookRepository.delete(book);

        return book;
    }
}
