package com.bestmatched.restaurants.domains;

import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import lombok.Data;

import static java.lang.Integer.parseInt;

@Data
public class Cuisine {

    private final int id;
    private final String name;

    public Cuisine(final CuisineRecord cuisineRecord) {
        this.id = parseInt(cuisineRecord.getId());
        this.name = cuisineRecord.getName();
    }
}
