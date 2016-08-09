package com.xyzcorp;

import java.util.function.Supplier;

public class LambdaDie implements Die {
    private final Supplier<Integer> supplier;
    private final Integer pips;

    public LambdaDie(Supplier<Integer> supplier) {
       this(supplier, 1);
    }

    public LambdaDie(Supplier<Integer> supplier, Integer pips) {
        this.supplier = supplier;
        this.pips = pips;
    }

    public LambdaDie roll() {
        return new LambdaDie(supplier, supplier.get());
    }

    public int getPips() {
        return pips;
    }
}
