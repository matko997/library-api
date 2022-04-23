package com.libraryapp.libraryapp.api.exception.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ApiResponse {
    private String message;
    private Instant timestamp;

    public ApiResponse() {
        this.timestamp= Instant.now();
    }
    public ApiResponse(Throwable throwable) {
        this();
        this.message=throwable.getLocalizedMessage();
    }


}
