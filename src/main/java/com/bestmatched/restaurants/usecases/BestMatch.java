package com.bestmatched.restaurants.usecases;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.gateways.web.response.RestaurantResponse;
import com.bestmatched.restaurants.usecases.filter.ClassificationFilter;
import com.bestmatched.restaurants.usecases.sort.ClassificationSort;
import com.bestmatched.restaurants.usecases.util.CollectionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BestMatch {
    private final Collection<ClassificationFilter> filters;
    private final Collection<ClassificationSort> sorts;


    public RestaurantResponse match(final Collection<Restaurant> restaurants,
                                    final SearchRestaurant searchRestaurant) {

        final Set<Restaurant> filteredRestaurants = getFilteredRestaurants(restaurants, searchRestaurant);

        final Set<Restaurant> orderedRestaurants = getOrderedRestaurants(filteredRestaurants);

        final Set<Restaurant> limitRestaurants = getLimitRestaurants(orderedRestaurants);

        return new RestaurantResponse(limitRestaurants);
    }

    private Set<Restaurant> getFilteredRestaurants(final Collection<Restaurant> restaurants,
                                                   final SearchRestaurant searchRestaurant) {
        return filters.stream()
                .map(filter -> filter.apply(restaurants, searchRestaurant))
                .reduce(CollectionUtils::concatSets)
                .orElse(Set.of());
    }

    private Set<Restaurant> getOrderedRestaurants(final Collection<Restaurant> filteredRestaurants) {
        return sorts.stream()
                .map(sort -> sort.apply(filteredRestaurants))
                .reduce(CollectionUtils::concatSets)
                .orElse(Set.of());
    }

    private Set<Restaurant> getLimitRestaurants(final Collection<Restaurant> orderedRestaurants) {
        return orderedRestaurants.stream().limit(5).collect(Collectors.toSet());
    }
}
