package com.bestmatched.restaurants.usecases.validator;

import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.usecases.exception.Message;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.bestmatched.restaurants.util.Constants.PRICE_ERROR;
import static java.lang.String.valueOf;
import static java.util.List.of;
import static java.util.Objects.isNull;

@Component
public class PriceValidator implements RestaurantSearchValidator {

    @Override
    public Collection<Message> execute(final SearchRestaurant searchRestaurant) {
        final Integer price = searchRestaurant.getPrice();
        if (isNull(price)) return of();
        return (price >= 10 && price <= 50) ? of() :
                of(Message.builder().value(valueOf(price)).errorMessage(PRICE_ERROR).build());
    }
}
