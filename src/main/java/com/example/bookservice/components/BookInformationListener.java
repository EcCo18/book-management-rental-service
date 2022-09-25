package com.example.bookservice.components;

import com.example.bookservice.models.dtos.BookDto;
import com.example.bookservice.services.BookInformationProcessService;
import com.example.bookservice.services.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BookInformationListener {

    private final BookInformationProcessService bookInformationProcessService;
    private final BookMapper bookMapper;

    @KafkaListener(
            topics = "isbn-book-information",
            groupId = "book-service",
            containerFactory = "bookDtoListener"
    )
    void listener(@Payload BookDto bookDto) {
        log.info("received book information for id=" + bookDto.getId() + " isbn=" + bookDto.getIsbn());
        bookInformationProcessService.processBookInformation(bookMapper.mapDtoToBook(bookDto));
    }
}
