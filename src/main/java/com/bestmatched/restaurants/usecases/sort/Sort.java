package com.bestmatched.restaurants.usecases.sort;

import com.bestmatched.restaurants.domains.Restaurant;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Sort implements ClassificationSort {

    @Override
    public Set<Restaurant> apply(final Collection<Restaurant> restaurants) {
        return restaurants.stream().sorted(sort()).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private Comparator<Restaurant> sort() {
        return Comparator.comparing(Restaurant::getDistance).reversed()
                .thenComparing(Restaurant::getCustomerRating)
                .thenComparing(Restaurant::getPrice).reversed();
    }
}
