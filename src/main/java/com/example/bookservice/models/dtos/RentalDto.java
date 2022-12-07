package com.example.bookservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {

    private Long rentalId;

    @NotNull
    private Long bookId;

    @NotNull
    private Long userId;

    private LocalDate rentalDate;
}
