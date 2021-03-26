package com.bestmatched.restaurants.gateways;

import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.file.record.RestaurantRecord;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.util.Collection;

public interface ReadFile {

    @PostConstruct
    Collection<RestaurantRecord> readCsvRestaurant() throws FileNotFoundException;

    @PostConstruct
    Collection<CuisineRecord> readCsvCuisine() throws FileNotFoundException;
}
