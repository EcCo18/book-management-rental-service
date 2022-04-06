package com.example.bookservice.controller;

import com.example.bookservice.models.Book;
import com.example.bookservice.models.dtos.BookDto;
import com.example.bookservice.services.BookService;
import com.example.bookservice.services.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping()
    public ResponseEntity<List<BookDto>> getAllBooks() {
        log.info("received GET request for all books");
        return ResponseEntity.ok(bookMapper.mapBookListToDtoList(bookService.getAllBooks()));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("bookId") int bookId) {
        log.info("received GET for book with id: " + bookId);
        return bookService.findBook(bookId)
                .map(book -> ResponseEntity.ok(bookMapper.mapBookToDto(book)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto) {
        log.info("received POST for book");
        log.debug(bookDto.toString());
        Book createdBook = bookService.createBook(bookMapper.mapDtoToBook(bookDto));
        return ResponseEntity.ok(bookMapper.mapBookToDto(createdBook));
    }
}
