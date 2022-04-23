package com.libraryapp.libraryapp.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book")
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "is_available")
    Boolean isAvailable;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    Author author;

    public Book(String name, Boolean isAvailable, Author author) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.author = author;
    }
}
