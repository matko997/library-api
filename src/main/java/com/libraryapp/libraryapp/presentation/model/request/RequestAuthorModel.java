package com.libraryapp.libraryapp.presentation.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestAuthorModel {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
