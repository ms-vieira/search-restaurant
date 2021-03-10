package com.bestmatched.restaurants.usecases.filter;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CuisineFilter implements ClassificationFilter {

    @Override
    public Set<Restaurant> apply(final Collection<Restaurant> restaurants,
                                 final SearchRestaurant searchRestaurant) {
        return searchRestaurant.getCuisine().isEmpty() ? Set.of() :
                restaurants
                        .stream()
                        .filter(cuisine -> cuisine.getCuisine().contains(searchRestaurant.getCuisine()))
                        .collect(Collectors.toSet());
    }
}
