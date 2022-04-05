package com.example.bookservice.controller;

import com.example.bookservice.models.Book;
import com.example.bookservice.models.dtos.BookDto;
import com.example.bookservice.services.BookService;
import com.example.bookservice.services.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping()
    public List<BookDto> getAllBooks() {
        log.info("received GET request for all books");
        return bookMapper.mapBookListToDtoList(bookService.getAllBooks());
    }

    @PostMapping()
    public BookDto createBook(@Valid @RequestBody BookDto bookDto) {
        log.info("received POST for book");
        log.debug(bookDto.toString());
        Book createdBook = bookService.createBook(bookMapper.mapDtoToBook(bookDto));
        return bookMapper.mapBookToDto(createdBook);
    }
}
