package com.bestmatched.restaurants.gateways;

import com.bestmatched.restaurants.gateways.web.request.ParameterRequest;
import com.bestmatched.restaurants.gateways.web.response.RestaurantResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/restaurants")
public interface RestaurantResource {

    @PostMapping
    @ResponseStatus(OK)
    RestaurantResponse searchRestaurant(@RequestBody @Valid final ParameterRequest request)
            throws FileNotFoundException;
}