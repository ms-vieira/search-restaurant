package com.bestmatched.restaurants.gateways.web.response;

import com.bestmatched.restaurants.domains.Restaurant;
import lombok.Data;

import java.util.Collection;

@Data
public class RestaurantResponse {
    final Collection<Restaurant> restaurants;

    public RestaurantResponse(final Collection<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
