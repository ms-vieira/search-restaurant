package com.bestmatched.restaurants.usecases.filter;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;

import java.util.Collection;
import java.util.Set;

public interface ClassificationFilter {

    Set<Restaurant> apply(final Collection<Restaurant> restaurants, final SearchRestaurant searchRestaurant);
}
