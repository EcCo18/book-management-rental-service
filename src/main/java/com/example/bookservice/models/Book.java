package com.example.bookservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String isbn;
    @ElementCollection
    @CollectionTable(name="author_list", joinColumns = @JoinColumn(name = "id"))
    private List<String> authors;
    private int releaseYear;
    private String name;
}
