package com.example.bookservice.services;

import com.example.bookservice.models.Book;
import com.example.bookservice.repos.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookInformationProcessService {

    private final BookRepository bookRepository;

    public void processBookInformation(Book book) {
        log.info("updating book with id=" + book.getId() + " in db");
        bookRepository.save(book);
    }
}
