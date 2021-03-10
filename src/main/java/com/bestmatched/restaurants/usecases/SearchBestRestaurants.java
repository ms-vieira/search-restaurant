package com.bestmatched.restaurants.usecases;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.gateways.file.Read;
import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.web.response.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class SearchBestRestaurants {

    private final Read read;
    private final BestMatch bestMatch;

    public RestaurantResponse search(final SearchRestaurant searchRestaurant)
            throws FileNotFoundException {
        return bestMatch.match(getRestaurants(), searchRestaurant);
    }

    private Collection<Restaurant> getRestaurants() throws FileNotFoundException {
        final Collection<CuisineRecord> cuisineRecords = read.readCsvCuisine();
        return read.readCsvRestaurant().stream()
                .map(restaurant -> new Restaurant(restaurant, cuisineRecords))
                .collect(toList());
    }
}
