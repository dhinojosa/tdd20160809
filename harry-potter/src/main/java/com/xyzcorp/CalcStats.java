package com.xyzcorp;

import java.util.function.BiFunction;

public class CalcStats {

    private static void checkItemArray(int[] items) {
        if (items == null) throw new NullPointerException("Array is null");
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
        checkItemArray(items);
        return findByFunction(items, (result, nextValue) -> nextValue < result);
    }

    public static int getMaximum(int[] items) {
        checkItemArray(items);
        return findByFunction(items, (result, nextValue) -> nextValue > result);
    }
}










