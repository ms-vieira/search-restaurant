package com.bestmatched.restaurants.usecases.filter.chain;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;

import java.util.function.Predicate;

import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

public class NameStep extends FilterStep {

    @Override
    public Predicate<Restaurant> applyTo(Predicate<Restaurant> predicate,
                                         final SearchRestaurant searchRestaurant) {
        if (isNotBlank(searchRestaurant.getRestaurantName()))
            predicate = predicate.and(nameFilter(searchRestaurant.getRestaurantName()));
        return (nonNull(nextStep)) ? nextStep.applyTo(predicate, searchRestaurant) : predicate;
    }

    private Predicate<Restaurant> nameFilter(final String nameSearch) {
        return predicateName -> predicateName.getRestaurantName().toLowerCase().contains(nameSearch.toLowerCase());
    }
}
