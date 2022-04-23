package com.libraryapp.libraryapp.presentation.model.response;

import com.libraryapp.libraryapp.domain.model.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBookModel {
    private Long id;
    private String name;
    private Boolean isAvailable;
    private Author author;
}