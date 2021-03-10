package com.bestmatched.restaurants.usecases.util;

import lombok.experimental.UtilityClass;

import java.util.*;

import static java.util.Arrays.stream;

@UtilityClass
public class CollectionUtils {

    @SafeVarargs
    public static <T> Set<T> concatSets(final Collection<T>... originals) {
        final var set = new HashSet<T>();
        addAll(set, originals);
        return set;
    }

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
