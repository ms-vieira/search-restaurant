package com.bestmatched.restaurants.gateways.file.record;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class CuisineRecord {

    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String name;
}
