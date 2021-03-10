package com.bestmatched.restaurants.gateways.file.impl;

import com.bestmatched.restaurants.gateways.file.Read;
import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.file.record.RestaurantRecord;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class ReadImpl implements Read {

    @Override
    public Collection<RestaurantRecord> readCsvRestaurant() throws FileNotFoundException {
        final String fileRestaurant = "/home/matheus/workspace/restaurants/src/main/resources/restaurants.csv";
        final List<RestaurantRecord> restaurantRecords = new CsvToBeanBuilder<RestaurantRecord>(new FileReader(fileRestaurant))
                .withType(RestaurantRecord.class)
                .build()
                .parse();

        log.info("M=read, Reading the file = {}", restaurantRecords);
        return restaurantRecords;
    }

    @Override
    public Collection<CuisineRecord> readCsvCuisine() throws FileNotFoundException {
        final String fileCuisine = "/home/matheus/workspace/restaurants/src/main/resources/cuisines.csv";
        final List<CuisineRecord> cuisineRecords = new CsvToBeanBuilder<CuisineRecord>(new FileReader(fileCuisine))
                .withType(CuisineRecord.class)
                .build()
                .parse();

        log.info("M=read, Reading the file = {}", cuisineRecords);
        return cuisineRecords;
    }
}
