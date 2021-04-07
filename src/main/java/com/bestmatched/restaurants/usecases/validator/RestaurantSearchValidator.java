package com.bestmatched.restaurants.usecases.validator;

import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.usecases.exception.Message;

import java.util.Collection;

@FunctionalInterface
public interface RestaurantSearchValidator {

    Collection<Message> execute(final SearchRestaurant searchRestaurant);
}
