package com.bestmatched.restaurants.usecases;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.gateways.ReadFile;
import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.web.response.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Collection;

import static com.bestmatched.restaurants.domains.Restaurant.comparator;
import static com.bestmatched.restaurants.usecases.filter.RestaurantFilter.BestRestaurants;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class CustomizedRestaurantSearch {
    private final ReadFile readFile;

    public RestaurantResponse search(final SearchRestaurant searchRestaurant)
            throws FileNotFoundException {
        return new RestaurantResponse(getRestaurants().stream()
                .filter(BestRestaurants(searchRestaurant))
                .sorted(comparator())
                .limit(5)
                .collect(toList()));
    }

    private Collection<Restaurant> getRestaurants() throws FileNotFoundException {
        final Collection<CuisineRecord> cuisineRecords = readFile.readCsvCuisine();
        return readFile.readCsvRestaurant().stream()
                .map(restaurant -> new Restaurant(restaurant, cuisineRecords))
                .collect(toList());
    }
}
