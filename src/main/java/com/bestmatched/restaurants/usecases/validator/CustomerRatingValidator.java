package com.bestmatched.restaurants.usecases.validator;

import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.usecases.exception.Message;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.bestmatched.restaurants.util.Constants.CUSTOMER_RATING_ERROR;
import static java.lang.String.valueOf;
import static java.util.List.of;
import static java.util.Objects.isNull;

@Component
public class CustomerRatingValidator implements RestaurantSearchValidator {

    @Override
    public Collection<Message> execute(final SearchRestaurant searchRestaurant) {
        final Integer rating = searchRestaurant.getCustomerRating();
        if (isNull(rating)) return of();
        return (rating >= 1 && rating <= 5) ? of() :
                of(Message.builder().value(valueOf(rating)).errorMessage(CUSTOMER_RATING_ERROR).build());
    }
}
