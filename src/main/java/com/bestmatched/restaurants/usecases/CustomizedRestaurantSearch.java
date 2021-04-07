package com.bestmatched.restaurants.usecases;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.gateways.ReadFile;
import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.web.response.RestaurantResponse;
import com.bestmatched.restaurants.usecases.exception.InvalidParametersException;
import com.bestmatched.restaurants.usecases.exception.Message;
import com.bestmatched.restaurants.usecases.validator.RestaurantSearchValidator;
import com.bestmatched.restaurants.util.CollectionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Collection;

import static com.bestmatched.restaurants.domains.Restaurant.comparator;
import static com.bestmatched.restaurants.usecases.filter.RestaurantFilter.bestRestaurants;
import static java.util.List.of;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class CustomizedRestaurantSearch {
    private final ReadFile readFile;
    private final Collection<RestaurantSearchValidator> validators;

    public RestaurantResponse search(final SearchRestaurant searchRestaurant)
            throws FileNotFoundException {
        validation(apply(searchRestaurant));
        return new RestaurantResponse(getRestaurants().stream()
                .filter(bestRestaurants(searchRestaurant))
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

    private void validation(final Collection<Message> messages) {
        if (!messages.isEmpty()) throw new InvalidParametersException(messages);
    }

    private Collection<Message> apply(final SearchRestaurant searchRestaurant) {
        return validators.stream()
                .map(validator -> validator.execute(searchRestaurant))
                .reduce(of(), CollectionUtils::concatLists);
    }
}
