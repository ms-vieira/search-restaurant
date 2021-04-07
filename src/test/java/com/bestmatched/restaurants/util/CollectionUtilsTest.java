package com.bestmatched.restaurants.util;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.bestmatched.restaurants.util.CollectionUtils.concatLists;
import static java.util.Set.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionUtilsTest {

    private static final Collection<Integer> ONE = of(0, 1, 2, 3);
    private static final Collection<Integer> TWO = of(4, 5, 6, 7);
    private static final Collection<Integer> THREE = of(2, 3, 4, 5);

    @Test
    void should_concatLists_return_valid_list() {
        assertEquals(0, concatLists().size());
        assertEquals(0, concatLists(of()).size());
        assertEquals(0, concatLists(of(), of()).size());
        assertEquals(4, concatLists(of(), ONE).size());
        assertEquals(8, concatLists(ONE, TWO).size());
        assertEquals(8, concatLists(TWO, THREE).size());
        assertEquals(8, concatLists(ONE, THREE).size());
        assertEquals(12, concatLists(ONE, TWO, THREE).size());
    }
}