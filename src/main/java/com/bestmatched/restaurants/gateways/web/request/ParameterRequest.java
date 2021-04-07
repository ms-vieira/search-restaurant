package com.bestmatched.restaurants.gateways.web.request;

import com.bestmatched.restaurants.domains.SearchRestaurant;
import lombok.Data;

import java.io.Serializable;

@Data
public class ParameterRequest implements Serializable {
    private String restaurantName;
    private Integer customerRating;
    private Integer distance;
    private Integer price;
    private String cuisine;

    public SearchRestaurant toSearchRestaurant() {
        return new SearchRestaurant(this);
    }
}
