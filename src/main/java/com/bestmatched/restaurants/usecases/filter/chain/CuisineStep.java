package com.bestmatched.restaurants.usecases.filter.chain;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;

import java.util.function.Predicate;

import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

public class CuisineStep extends FilterStep {

    @Override
    public Predicate<Restaurant> applyTo(Predicate<Restaurant> predicate,
                                         final SearchRestaurant searchRestaurant) {
        if (isNotBlank(searchRestaurant.getCuisine()))
            predicate = predicate.and(cuisineFilter(searchRestaurant.getCuisine()));
        return (nonNull(nextStep)) ? nextStep.applyTo(predicate, searchRestaurant) : predicate;
    }

    private Predicate<Restaurant> cuisineFilter(final String cuisineSearch) {
        return predicateCuisine -> predicateCuisine.getCuisine().toLowerCase().contains(cuisineSearch.toLowerCase());
    }
}
