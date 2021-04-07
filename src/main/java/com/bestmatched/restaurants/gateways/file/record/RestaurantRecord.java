package com.bestmatched.restaurants.gateways.file.record;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantRecord {

    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private String customerRating;

    @CsvBindByPosition(position = 2)
    private String distance;

    @CsvBindByPosition(position = 3)
    private String price;

    @CsvBindByPosition(position = 4)
    private String cuisineId;
}
