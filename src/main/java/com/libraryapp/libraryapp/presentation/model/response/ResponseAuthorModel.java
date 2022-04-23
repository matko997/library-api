package com.libraryapp.libraryapp.presentation.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseAuthorModel {
    private Long id;
    private String firstName;
    private String lastName;
}