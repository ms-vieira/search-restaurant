package com.bestmatched.restaurants.usecases.filter;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.usecases.filter.chain.*;
import lombok.experimental.UtilityClass;

import java.util.function.Predicate;

@UtilityClass
public class BestFilter {

    public static Predicate<Restaurant> applyBest(final SearchRestaurant searchRestaurant,
                                                  final Predicate<Restaurant> predicate) {
        final FilterStep chain = new NameStep();

        chain.andThen(new CustomerRatingStep())
                .andThen(new DistanceStep())
                .andThen(new PriceStep())
                .andThen(new CuisineStep());

        return chain.applyTo(predicate, searchRestaurant);
    }
}
