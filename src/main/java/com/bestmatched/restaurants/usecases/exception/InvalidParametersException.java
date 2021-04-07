package com.bestmatched.restaurants.usecases.exception;

import lombok.Getter;

import java.util.Collection;

@Getter
public class InvalidParametersException extends RuntimeException {
    final Collection<Message> messages;

    public InvalidParametersException(final Collection<Message> messages) {
        super("InvalidParametersException");
        this.messages = messages;
    }
}
