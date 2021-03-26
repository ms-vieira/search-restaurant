package com.bestmatched.restaurants.gateways.file;

import com.bestmatched.restaurants.gateways.ReadFile;
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
public class ReadFileImpl implements ReadFile {

    @Override
    public Collection<RestaurantRecord> readCsvRestaurant() throws FileNotFoundException {
        final String fileRestaurant = "src/main/resources/restaurants.csv";
        final List<RestaurantRecord> restaurantRecords = new CsvToBeanBuilder<RestaurantRecord>(new FileReader(fileRestaurant))
                .withType(RestaurantRecord.class)
                .build()
                .parse();

        log.info("M=read, Reading the file = {}", restaurantRecords);
        return restaurantRecords;
    }

    @Override
    public Collection<CuisineRecord> readCsvCuisine() throws FileNotFoundException {
        final String fileCuisine = "src/main/resources/cuisines.csv";
        final List<CuisineRecord> cuisineRecords = new CsvToBeanBuilder<CuisineRecord>(new FileReader(fileCuisine))
                .withType(CuisineRecord.class)
                .build()
                .parse();

        log.info("M=read, Reading the file = {}", cuisineRecords);
        return cuisineRecords;
    }
}
