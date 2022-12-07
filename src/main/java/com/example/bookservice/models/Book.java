package com.example.bookservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String isbn;

    @ElementCollection
    @CollectionTable(name="author_list", joinColumns = @JoinColumn(name = "id"))
    private List<String> authors;

    private int releaseYear;
    private String name;
}
