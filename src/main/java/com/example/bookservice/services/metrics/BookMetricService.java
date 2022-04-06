package com.example.bookservice.services.metrics;

import com.example.bookservice.models.Book;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookMetricService {

    private Counter bookCreatedCounter;
    private Counter bookReceivedCounter;
    private final MeterRegistry meterRegistry;

    @Autowired
    public BookMetricService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        initBookCounters();
    }

    private void initBookCounters() {
        log.info("init all book counters");
        bookCreatedCounter = Counter.builder("books.created")
                .description("number of books created")
                .register(meterRegistry);
        bookReceivedCounter = Counter.builder("books.received")
                .description("number of times all books were received")
                .register(meterRegistry);
    }

    public void processCreation(Book createdBook) {
        log.debug("incrementing book created counter, then returning createdBookObject: " + createdBook);
        bookCreatedCounter.increment();
    }

    public void processReceived() {
        log.debug("incrementing all books received counter");
        bookReceivedCounter.increment();
    }
}
