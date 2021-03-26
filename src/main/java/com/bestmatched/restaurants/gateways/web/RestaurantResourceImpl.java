package com.bestmatched.restaurants.gateways.web;

import com.bestmatched.restaurants.gateways.web.request.ParameterRequest;
import com.bestmatched.restaurants.gateways.RestaurantResource;
import com.bestmatched.restaurants.gateways.web.response.RestaurantResponse;
import com.bestmatched.restaurants.usecases.CustomizedRestaurantSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
@RequiredArgsConstructor
public class RestaurantResourceImpl implements RestaurantResource {

    private final CustomizedRestaurantSearch customizedRestaurantSearch;

    @Override
    public RestaurantResponse searchRestaurant(final ParameterRequest request) throws FileNotFoundException {
        return customizedRestaurantSearch.search(request.toSearchRestaurant());
    }
}
