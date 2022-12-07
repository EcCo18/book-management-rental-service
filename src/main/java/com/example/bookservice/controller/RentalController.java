package com.example.bookservice.controller;

import com.example.bookservice.models.dtos.RentalDto;
import com.example.bookservice.services.RentalService;
import com.example.bookservice.services.mapper.RentalMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rentals")
@RequiredArgsConstructor
@Slf4j
public class RentalController {

    private final RentalService rentalService;
    private final RentalMapper rentalMapper;

    @GetMapping()
    public ResponseEntity<List<RentalDto>> getAllRentals() {
        log.info("received GET request for all rentals");
        return ResponseEntity.ok(
                rentalService.getAllRentals().stream().map(rentalMapper::mapRentalToDto).toList()
        );
    }

    @PostMapping()
    public ResponseEntity<RentalDto> postNewRental(@Valid @RequestBody RentalDto rentalDto) {
        log.info("received POST request for rental");
        return ResponseEntity.status(201).body(
                rentalMapper.mapRentalToDto(
                        rentalService.createRental(rentalMapper.mapDtoToRental(rentalDto))
                )
        );
    }

    // ToDo
    @GetMapping("/{rentalId}")
    public ResponseEntity<RentalDto> getRentalById(@PathVariable long rentalId) {


        return null;
    }

    // ToDo
    @DeleteMapping("/{rentalId}")
    public ResponseEntity<RentalDto> deleteRentalById(@PathVariable long rentalId) {
        log.info("received DELETE request for rental with id: " + rentalId);
        return ResponseEntity.ok(
                rentalMapper.mapRentalToDto(
                        rentalService.deleteRentalById(rentalId)
                )
        );
    }
}
