package com.bestmatched.restaurants.usecases.validator;

import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.gateways.web.request.ParameterRequest;
import com.bestmatched.restaurants.usecases.exception.Message;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.bestmatched.restaurants.util.Constants.CUSTOMER_RATING_ERROR;
import static org.junit.jupiter.api.Assertions.*;

class CustomerRatingValidatorTest {

    private final CustomerRatingValidator validator = new CustomerRatingValidator();

    @Test
    void should_validate_if_the_customers_rating_is_between_one_and_five_error() {
        final Collection<Message> errors = validator.execute(buildSearchError());
        assertFalse(errors.isEmpty());
        assertEquals(CUSTOMER_RATING_ERROR, errors.stream().findFirst().get().getErrorMessage());
    }

    @Test
    void should_validate_if_the_customers_rating_is_between_one_and_five_success() {
        final Collection<Message> errors = validator.execute(buildSearch());
        assertTrue(errors.isEmpty());
    }

    private SearchRestaurant buildSearchError() {
        return new SearchRestaurant(ParameterRequest.builder()
                .restaurantName("delicious")
                .customerRating(10)
                .distance(3)
                .price(20)
                .build());
    }

    private SearchRestaurant buildSearch() {
        return new SearchRestaurant(ParameterRequest.builder()
                .restaurantName("delicious")
                .customerRating(3)
                .distance(3)
                .price(20)
                .build());
    }
}