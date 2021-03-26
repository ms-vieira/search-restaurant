package com.bestmatched.restaurants.usecases.filter;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;
import lombok.experimental.UtilityClass;

import java.util.function.Predicate;

import static com.bestmatched.restaurants.domains.Restaurant.*;
import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

@UtilityClass
public class BestFilter {

    public static Predicate<Restaurant> applyBest(final SearchRestaurant searchRestaurant,
                                                  final Predicate<Restaurant> predicate) {
        Predicate<Restaurant> buildFilter = predicate;
        if (isNotBlank(searchRestaurant.getRestaurantName()))
            buildFilter = buildFilter.and(nameFilter(searchRestaurant.getRestaurantName()));

        if (nonNull(searchRestaurant.getCustomerRating()))
            buildFilter = buildFilter.and(ratingFilter(searchRestaurant.getCustomerRating()));

        if (nonNull(searchRestaurant.getDistance()))
            buildFilter = buildFilter.and(distanceFilter(searchRestaurant.getDistance()));

        if (nonNull(searchRestaurant.getPrice()))
            buildFilter = buildFilter.and(priceFilter(searchRestaurant.getPrice()));

        if (isNotBlank(searchRestaurant.getCuisine()))
            buildFilter = buildFilter.and(cuisineFilter(searchRestaurant.getCuisine()));

        return buildFilter;
    }
}
