package com.bestmatched.restaurants.domains;

import com.bestmatched.restaurants.gateways.web.request.ParameterRequest;
import lombok.Getter;

@Getter
public class SearchRestaurant {
    private final String restaurantName;
    private final Integer customerRating;
    private final Integer distance;
    private final Integer price;
    private final String cuisine;

    public SearchRestaurant(final ParameterRequest request) {
        this.restaurantName = request.getRestaurantName();
        this.customerRating = request.getCustomerRating();
        this.distance = request.getDistance();
        this.price = request.getPrice();
        this.cuisine = request.getCuisine();
    }
}
