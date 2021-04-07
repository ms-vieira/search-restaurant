package com.bestmatched.restaurants.util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.stream;

@UtilityClass
public class CollectionUtils {

    @SafeVarargs
    public static <T> List<T> concatLists(final Collection<T>... originals) {
        final var list = new ArrayList<T>();
        addAll(list, originals);
        return list;
    }

    @SafeVarargs
    private static <T> void addAll(final Collection<T> col, final Collection<T>... originals) {
        stream(originals).forEach(col::addAll);
    }
}
