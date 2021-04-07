package com.bestmatched.restaurants.usecases;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.domains.SearchRestaurant;
import com.bestmatched.restaurants.gateways.ReadFile;
import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.file.record.RestaurantRecord;
import com.bestmatched.restaurants.gateways.web.request.ParameterRequest;
import com.bestmatched.restaurants.gateways.web.response.RestaurantResponse;
import com.bestmatched.restaurants.usecases.exception.InvalidParametersException;
import com.bestmatched.restaurants.usecases.exception.Message;
import com.bestmatched.restaurants.usecases.validator.RestaurantSearchValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.util.List;

import static com.bestmatched.restaurants.util.Constants.CUSTOMER_RATING_ERROR;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomizedRestaurantSearchTest {

    @Mock
    private ReadFile readFile;
    @Mock
    private RestaurantSearchValidator validators;

    private CustomizedRestaurantSearch customizedRestaurantSearch;

    @BeforeEach
    void init() {
        customizedRestaurantSearch = new CustomizedRestaurantSearch(readFile, of(validators));
    }

    @Test
    void should_find_until_five_best_restaurants() throws FileNotFoundException {
        when(readFile.readCsvCuisine()).thenReturn(buildCuisine());
        when(readFile.readCsvRestaurant()).thenReturn(buildRestaurantRecord());
        when(validators.execute(any())).thenReturn(of());

        final RestaurantResponse result = customizedRestaurantSearch.search(buildSearch());

        assertEquals(1, result.getRestaurants().size());
        assertEquals("delicious", result.getRestaurants().stream().map(Restaurant::getRestaurantName).findFirst().get());
        assertEquals(4, result.getRestaurants().stream().map(Restaurant::getCustomerRating).findFirst().get());
        assertEquals(3, result.getRestaurants().stream().map(Restaurant::getDistance).findFirst().get());
        assertEquals(20, result.getRestaurants().stream().map(Restaurant::getPrice).findFirst().get());
        assertEquals("chinese", result.getRestaurants().stream().map(Restaurant::getCuisine).findFirst().get());
        verify(readFile, times(1)).readCsvCuisine();
        verify(readFile, times(1)).readCsvRestaurant();
    }

    @Test
    void should_throw_an_exception_when_trying_to_read_a_file_with_an_error() throws FileNotFoundException {
        when(readFile.readCsvCuisine()).thenThrow(FileNotFoundException.class);
        when(validators.execute(any())).thenReturn(of());

        assertThrows(FileNotFoundException.class, () -> customizedRestaurantSearch.search(buildSearch()));
        verify(readFile, times(1)).readCsvCuisine();
    }

    @Test
    void should_throw_an_exception_when_a_search_parameter_is_not_valid() {
        when(validators.execute(any())).thenReturn(of(Message.builder()
                .value("-1")
                .errorMessage(CUSTOMER_RATING_ERROR)
                .build()));

        assertThrows(InvalidParametersException.class, () ->
                customizedRestaurantSearch.search(buildSearch()));
    }

    private SearchRestaurant buildSearch() {
        return new SearchRestaurant(ParameterRequest.builder()
                .restaurantName("delicious")
                .customerRating(4)
                .distance(3)
                .price(20)
                .build());
    }

    private List<CuisineRecord> buildCuisine() {
        final CuisineRecord record = new CuisineRecord();
        record.setId("1");
        record.setName("chinese");
        return List.of(record);
    }

    private List<RestaurantRecord> buildRestaurantRecord() {
        final RestaurantRecord record = new RestaurantRecord();
        record.setCuisineId("1");
        record.setDistance("3");
        record.setCustomerRating("4");
        record.setPrice("20");
        record.setName("delicious");
        return List.of(record);
    }
}