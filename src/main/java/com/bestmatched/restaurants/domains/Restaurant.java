package com.bestmatched.restaurants.domains;

import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.file.record.RestaurantRecord;
import lombok.Data;

import java.util.Collection;

import static java.lang.Integer.parseInt;

@Data
public class Restaurant {
    private final String restaurantName;
    private final int customerRating;
    private final int distance;
    private final int price;
    private final String cuisine;

    public Restaurant(final RestaurantRecord restaurantRecord,
                      final Collection<CuisineRecord> cuisineRecords) {
        this.restaurantName = restaurantRecord.getName();
        this.customerRating = parseInt(restaurantRecord.getCustomerRating());
        this.distance = parseInt(restaurantRecord.getDistance());
        this.price = parseInt(restaurantRecord.getPrice());
        this.cuisine = cuisineRecords.stream()
                .filter(csn -> csn.getId().equals(restaurantRecord.getCuisineId()))
                .map(CuisineRecord::getName)
                .findFirst()
                .orElse("Not Found");
    }
}
