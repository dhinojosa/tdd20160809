package com.xyzcorp;

import java.util.Objects;
import java.util.function.BiFunction;

public class CalcStats {

    private static String ARRAY_IS_NULL_MSG = "Array is null";

    private static void checkItemArray(int[] items) {
        if (items.length == 0)
            throw new IllegalArgumentException("Array length is zero");
    }

    private static int findByFunction(int[] items,
                                      BiFunction<Integer, Integer, Boolean>
                                              biFunction) {
        int result = items[0];
        for (int i = 1; i < items.length; i++) {
            int nextValue = items[i];
            if (biFunction.apply(result, nextValue)) result = nextValue;
        }
        return result;
    }

    public static int getMinimum(int[] items) {
        Objects.requireNonNull(items, ARRAY_IS_NULL_MSG);
        checkItemArray(items);
        return findByFunction(items, (result, nextValue) -> nextValue < result);
    }

    public static int getMaximum(int[] items) {
        Objects.requireNonNull(items, ARRAY_IS_NULL_MSG);
        checkItemArray(items);
        return findByFunction(items, (result, nextValue) -> nextValue > result);
    }

    public static int getNumberOfElements(int[] items) {
        Objects.requireNonNull(items, ARRAY_IS_NULL_MSG);
        return items.length;
    }

    public static double getAverage(int[] items) {
        Objects.requireNonNull(items, ARRAY_IS_NULL_MSG);
        if (items.length == 0) return 0;
        int result = 0;
        for (int item : items) {
            result += item;
        }
        return result / (items.length * 1.0);
    }
}










