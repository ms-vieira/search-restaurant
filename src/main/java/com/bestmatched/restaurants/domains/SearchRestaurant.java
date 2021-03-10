package com.bestmatched.restaurants.domains;

import com.bestmatched.restaurants.gateways.web.request.ParameterRequest;
import lombok.Data;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static java.util.Objects.isNull;

@Data
public class SearchRestaurant {
    private final String restaurantName;
    private final int customerRating;
    private final int distance;
    private final int price;
    private final String cuisine;

    public SearchRestaurant(final ParameterRequest request) {
        this.restaurantName = isNull(request.getRestaurantName()) ? "" : request.getRestaurantName();
        this.customerRating = request.getCustomerRating();
        this.distance = request.getDistance();
        this.price = request.getPrice();
        this.cuisine = isNull(request.getCuisine()) ? "" : request.getCuisine();
    }
}
