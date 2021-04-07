package com.bestmatched.restaurants.usecases.filter.chain;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;

import java.util.function.Predicate;

public abstract class FilterStep {
    protected FilterStep nextStep;

    public FilterStep andThen(FilterStep nextStep) {
        this.nextStep = nextStep;
        return nextStep;
    }

    public abstract Predicate<Restaurant> applyTo(final Predicate<Restaurant> predicate,
                                                  final SearchRestaurant searchRestaurant);
}
