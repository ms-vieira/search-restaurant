package com.bestmatched.restaurants.gateways.web.request;

import com.bestmatched.restaurants.domains.SearchRestaurant;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public class ParameterRequest implements Serializable {

    private String restaurantName;
    @Min(1)
    @Max(5)
    private int customerRating;
    @Min(1)
    @Max(10)
    private int distance;
    @Min(10)
    @Max(50)
    private int price;
    private String cuisine;

    public SearchRestaurant toSearchRestaurant() {
        return new SearchRestaurant(this);
    }
}
