package com.bestmatched.restaurants.domains;

import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.file.record.RestaurantRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private String restaurantName;
    private Integer customerRating;
    private Integer distance;
    private Integer price;
    private String cuisine;

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
            int result = comparatorDistance(r1, r2);
            if (result == 0)
                result = comparatorCustomerRating(r1, r2);
            if (result == 0)
                result = comparatorPrice(r1, r2);
            return result;
        };
    }

    private static int comparatorDistance(final Restaurant restaurant1,
                                          final Restaurant restaurant2) {
        return restaurant1.getDistance().compareTo(restaurant2.getDistance());
    }

    private static int comparatorCustomerRating(final Restaurant restaurant1,
                                                final Restaurant restaurant2) {
        return restaurant2.getCustomerRating().compareTo(restaurant1.getCustomerRating());
    }

    private static int comparatorPrice(final Restaurant restaurant1,
                                       final Restaurant restaurant2) {
        return restaurant1.getPrice().compareTo(restaurant2.getPrice());
    }
}
