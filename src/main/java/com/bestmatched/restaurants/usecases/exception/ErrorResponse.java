package com.bestmatched.restaurants.usecases.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static lombok.AccessLevel.PRIVATE;

@JsonAutoDetect(fieldVisibility = ANY)
@RequiredArgsConstructor(access = PRIVATE)
public class ErrorResponse {
    private final Collection<Message> errors;
    public static ErrorResponse of(final Collection<Message> errors) {
        return new ErrorResponse(errors);
    }
}
