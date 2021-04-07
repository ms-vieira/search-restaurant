package com.bestmatched.restaurants.configs;

import com.bestmatched.restaurants.usecases.exception.ErrorResponse;
import com.bestmatched.restaurants.usecases.exception.InvalidParametersException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.bestmatched.restaurants.usecases.exception.ErrorResponse.of;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ApiErrorHandler {
    public static final String LOG_EXCEPTION = "Exception= {}, Stack Trace= {}";

    @ExceptionHandler(InvalidParametersException.class)
    public ResponseEntity<ErrorResponse> handleInvalidParametersException(
            final InvalidParametersException exception) {
        ResponseEntity<ErrorResponse> error =
                status(BAD_REQUEST)
                        .body(of(exception.getMessages()));
        log.error(LOG_EXCEPTION, error, exception.getMessage());
        return error;
    }
}
