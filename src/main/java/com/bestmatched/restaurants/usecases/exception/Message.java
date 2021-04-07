package com.bestmatched.restaurants.usecases.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Data
@JsonAutoDetect(fieldVisibility = ANY)
@Builder
@RequiredArgsConstructor
public class Message {
    private final String value;
    private final String errorMessage;
}
