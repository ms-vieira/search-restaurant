package com.bestmatched.restaurants.usecases.validator;

import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.usecases.exception.Message;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.bestmatched.restaurants.util.Constants.DISTANCE_ERROR;
import static java.lang.String.valueOf;
import static java.util.List.of;
import static java.util.Objects.isNull;

@Component
public class DistanceValidator implements RestaurantSearchValidator {

    @Override
    public Collection<Message> execute(final SearchRestaurant searchRestaurant) {
        final Integer distance = searchRestaurant.getDistance();
        if (isNull(distance)) return of();
        return (distance >= 1 && distance <= 10) ? of() :
                of(Message.builder().value(valueOf(distance)).errorMessage(DISTANCE_ERROR).build());
    }
}
