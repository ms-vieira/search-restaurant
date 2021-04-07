package com.bestmatched.restaurants.usecases.filter.chain;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;

import java.util.function.Predicate;

import static java.util.Objects.nonNull;

public class CustomerRatingStep extends FilterStep {

    @Override
    public Predicate<Restaurant> applyTo(Predicate<Restaurant> predicate,
                                  final SearchRestaurant searchRestaurant) {
        if (nonNull(searchRestaurant.getCustomerRating()))
            predicate = predicate.and(ratingFilter(searchRestaurant.getCustomerRating()));
        return (nonNull(nextStep)) ? nextStep.applyTo(predicate, searchRestaurant) : predicate;
    }

    private Predicate<Restaurant> ratingFilter(final Integer ratingSearch) {
        return predicateRating -> predicateRating.getCustomerRating().compareTo(ratingSearch) >= 0;
    }
}
