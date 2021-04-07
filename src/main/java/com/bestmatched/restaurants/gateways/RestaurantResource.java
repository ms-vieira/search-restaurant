package com.bestmatched.restaurants.gateways;

import com.bestmatched.restaurants.gateways.web.response.RestaurantResponse;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/restaurants")
public interface RestaurantResource {

    @GetMapping
    @ResponseStatus(OK)
    RestaurantResponse searchRestaurant(
            @RequestParam(value = "restaurantName", required = false) final String restaurantName,
            @RequestParam(value = "customerRating", required = false) final Integer customerRating,
            @RequestParam(value = "distance", required = false) final Integer distance,
            @RequestParam(value = "price", required = false) final Integer price,
            @RequestParam(value = "cuisine", required = false) final String cuisine)
            throws FileNotFoundException;
}
