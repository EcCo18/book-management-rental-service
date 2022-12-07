package com.example.bookservice.services.mapper;

import com.example.bookservice.models.Rental;
import com.example.bookservice.models.dtos.RentalDto;
import com.example.bookservice.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RentalMapper {

    private final BookService bookService;

    public RentalDto mapRentalToDto(Rental rental) {
        return RentalDto.builder()
                .rentalId(rental.getRentalId())
                .rentalDate(rental.getRentalTime())
                .bookId(rental.getBook().getId())
                .userId(rental.getUserId())
                .build();
    }

    public Rental mapDtoToRental(RentalDto rentalDto) throws NoSuchElementException {
        Rental rental = Rental.builder()
                .rentalTime(rentalDto.getRentalDate())
                .userId(rentalDto.getUserId())
                .build();

        rental.setBook(
                bookService.findBook(rentalDto.getBookId()).orElseThrow()
        );

        return rental;
    }
}
