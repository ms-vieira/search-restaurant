package com.bestmatched.restaurants.gateways.web.resource.impl;

import com.bestmatched.restaurants.gateways.web.request.ParameterRequest;
import com.bestmatched.restaurants.gateways.web.resource.RestaurantResource;
import com.bestmatched.restaurants.gateways.web.response.RestaurantResponse;
import com.bestmatched.restaurants.usecases.SearchBestRestaurants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
@RequiredArgsConstructor
public class RestaurantResourceImpl implements RestaurantResource {

    private final SearchBestRestaurants searchBestRestaurants;

    @Override
    public RestaurantResponse searchRestaurant(final ParameterRequest request) throws FileNotFoundException {
        return searchBestRestaurants.search(request.toSearchRestaurant());
    }
}
