package com.example.bookservice.services.mapper;

import com.example.bookservice.models.Book;
import com.example.bookservice.models.dtos.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookMapper {

    public Book mapDtoToBook(BookDto bookDto) {
        return Book.builder()
                .id(bookDto.getId())
                .authors(bookDto.getAuthors())
                .releaseYear(bookDto.getReleaseYear())
                .isbn(bookDto.getIsbn())
                .name(bookDto.getName())
                .build();
    }

    public List<Book> mapDtoListToBookList(List<BookDto> bookDtoList) {
        return bookDtoList.stream().map(this::mapDtoToBook).toList();
    }

    public BookDto mapBookToDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .authors(book.getAuthors())
                .releaseYear(book.getReleaseYear())
                .isbn(book.getIsbn())
                .name(book.getName())
                .build();
    }

    public List<BookDto> mapBookListToDtoList(List<Book> bookList) {
        return bookList.stream().map(this::mapBookToDto).toList();
    }
}
