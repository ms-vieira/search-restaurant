package com.bestmatched.restaurants.usecases.sort;

import com.bestmatched.restaurants.domains.Restaurant;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface ClassificationSort {

    Set<Restaurant> apply(final Collection<Restaurant> restaurants);
}
