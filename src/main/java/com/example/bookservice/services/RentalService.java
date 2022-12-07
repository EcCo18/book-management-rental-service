package com.example.bookservice.services;

import com.example.bookservice.models.Rental;
import com.example.bookservice.repos.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;

    public Rental findRentalById(Long id) throws NoSuchElementException {
        return rentalRepository.findById(id).orElseThrow();
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental createRental(Rental rental) {
        rental.setRentalTime(LocalDate.now());

        return rentalRepository.save(rental);
    }

    public Rental deleteRentalById(Long id) throws NoSuchElementException {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rental);

        return rental;
    }
}
