package com.xyzcorp;

import org.testng.annotations.Test;

import java.util.Random;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaDieTest {

    @Test
    public void testRollOf4() {
        LambdaDie die = new LambdaDie(() -> 4); //Subject Under Test
        LambdaDie rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(4);
    }


    @Test
    public void testRollWithRealRandom() {
        Random random = new Random();
        LambdaDie die = new LambdaDie(() -> random.nextInt(6) + 1); //Subject Under Test
        LambdaDie rolledDie = die.roll();

    }

}







