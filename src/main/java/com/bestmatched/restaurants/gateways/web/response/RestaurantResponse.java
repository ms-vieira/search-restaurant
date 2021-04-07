package com.bestmatched.restaurants.gateways.web.response;

import com.bestmatched.restaurants.domains.Restaurant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
public class RestaurantResponse {
    private Collection<Restaurant> restaurants;

    public RestaurantResponse(final Collection<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
