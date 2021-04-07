package com.bestmatched.restaurants.usecases.filter.chain;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;

import java.util.function.Predicate;

import static java.util.Objects.nonNull;

public class DistanceStep extends FilterStep {

    @Override
    public Predicate<Restaurant> applyTo(Predicate<Restaurant> predicate,
                                         final SearchRestaurant searchRestaurant) {
        if (nonNull(searchRestaurant.getDistance()))
            predicate = predicate.and(distanceFilter(searchRestaurant.getDistance()));
        return (nonNull(nextStep)) ? nextStep.applyTo(predicate, searchRestaurant) : predicate;
    }

    private Predicate<Restaurant> distanceFilter(final Integer distanceSearch) {
        return predicateDistance -> predicateDistance.getDistance().compareTo(distanceSearch) <= 0;
    }
}
