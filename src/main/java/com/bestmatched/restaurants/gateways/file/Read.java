package com.bestmatched.restaurants.gateways.file;

import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.file.record.RestaurantRecord;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

public interface Read {

    Collection<RestaurantRecord> readCsvRestaurant() throws FileNotFoundException;

    Collection<CuisineRecord> readCsvCuisine() throws FileNotFoundException;
}
