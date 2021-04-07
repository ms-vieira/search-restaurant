package com.bestmatched.restaurants.gateways;

import com.bestmatched.restaurants.domains.Restaurant;
import com.bestmatched.restaurants.gateways.file.record.CuisineRecord;
import com.bestmatched.restaurants.gateways.file.record.RestaurantRecord;
import com.bestmatched.restaurants.gateways.web.response.RestaurantResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;

import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RestaurantResourceTest {
    private static String RESTAURANTS_URL = "/restaurants";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ReadFile readFile;

    @Test
    void should_return_five_the_best_restaurants() throws Exception {
        when(readFile.readCsvCuisine()).thenReturn(buildCuisine());
        when(readFile.readCsvRestaurant()).thenReturn(buildRestaurantRecord());
        final MvcResult result = getRestaurants().andExpect(status().isOk()).andReturn();
        final RestaurantResponse response = of(result, RestaurantResponse.class);
        assertNotNull(response);
        assertEquals("delicious", response.getRestaurants().stream().findFirst().get().getRestaurantName());
        assertEquals(4, response.getRestaurants().stream().map(Restaurant::getCustomerRating).findFirst().get());
        assertEquals(3, response.getRestaurants().stream().map(Restaurant::getDistance).findFirst().get());
        assertEquals(20, response.getRestaurants().stream().map(Restaurant::getPrice).findFirst().get());
        assertEquals("chinese", response.getRestaurants().stream().map(Restaurant::getCuisine).findFirst().get());
    }

    private ResultActions getRestaurants() throws Exception {
        MockHttpServletRequestBuilder builder = get(RESTAURANTS_URL)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON);
        builder.param("restaurantName", "delicious");
        builder.param("customerRating", valueOf(4));
        builder.param("distance", valueOf(3));
        builder.param("price", valueOf(20));
        return mockMvc.perform(builder);
    }

    private <T> T of(MvcResult result, Class<T> tClass) throws Exception {
        return this.mapper.readValue(result.getResponse().getContentAsString(), tClass);
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