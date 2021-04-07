package com.bestmatched.restaurants.domains;

import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.file.record.RestaurantRecord;
import lombok.Data;

import java.util.Collection;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

@Data
public class Restaurant {
    private final String restaurantName;
    private final Integer customerRating;
    private final Integer distance;
    private final Integer price;
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

    public static Comparator<Restaurant> comparator() {
        return (r1, r2) -> {
            int c;
            c = r1.getDistance().compareTo(r2.getDistance());
            if (c == 0) {
                c = r2.getCustomerRating().compareTo(r1.getCustomerRating());
            }
            if (c == 0) {
                c = r1.getPrice().compareTo(r2.getPrice());
            }
            return c;
        };
    }
}
