package com.example.bookservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int id;

    @NotNull
    private String author;

    @Min(1)
    private int releaseYear;

    @NotEmpty
    private String isbn;

    @NotEmpty
    private String name;
}
