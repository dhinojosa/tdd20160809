package com.xyzcorp;

import java.util.Objects;
import java.util.Random;

public class DieImpl implements Die {

    public static final int MAX_SIDES = 6;
    private final int pips;
    private final Random random;

    public DieImpl(Random random) {
        this(random, 1);
    }

    public DieImpl(Random random, int pips) {
        Objects.requireNonNull(random, "Random is null");
        this.random = random;
        this.pips = pips;
    }

    @Override
    public int getPips() {
        return pips;
    }

    @Override
    public Die roll() {
        return new DieImpl(random, random.nextInt(MAX_SIDES) + 1);
    }
}
