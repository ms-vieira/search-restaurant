package com.bestmatched.restaurants.usecases.filter;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;

import java.util.function.Predicate;

import static com.bestmatched.restaurants.usecases.filter.BestFilter.applyBest;

public interface RestaurantFilter {

    static Predicate<Restaurant> bestRestaurants(final SearchRestaurant searchRestaurant) {
        final Predicate<Restaurant> predicate = test -> true;
        return applyBest(searchRestaurant, predicate);
    }
}
