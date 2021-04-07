package com.bestmatched.restaurants.usecases.filter.chain;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;

import java.util.function.Predicate;

import static java.util.Objects.nonNull;

public class PriceStep extends FilterStep {

    @Override
    public Predicate<Restaurant> applyTo(Predicate<Restaurant> predicate,
                                         final SearchRestaurant searchRestaurant) {
        if (nonNull(searchRestaurant.getPrice()))
            predicate = predicate.and(priceFilter(searchRestaurant.getPrice()));
        return (nonNull(nextStep)) ? nextStep.applyTo(predicate, searchRestaurant) : predicate;
    }

    private Predicate<Restaurant> priceFilter(final Integer priceSearch) {
        return predicatePrice -> predicatePrice.getPrice().compareTo(priceSearch) <= 0;
    }
}
