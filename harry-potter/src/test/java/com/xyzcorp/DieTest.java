package com.xyzcorp;

import org.testng.annotations.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

public class DieTest {

    @Test
    public void testRollOf4() {
        //Stub of the Collaborator
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };

        Die die = new Die(random); //Subject Under Test
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(4);
    }


    @Test
    public void testDieDefaultIs1WithRandom() {
        Die die = new Die(new Random());  //Subject Under Test
        assertThat(die.getPips()).isEqualTo(1);
    }

    @Test
    public void testRollOf4Twice() {
        //Stub of the Collaborator
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };

        Die die = new Die(random); //Subject Under Test
        Die rolledDie = die.roll().roll();
        assertThat(rolledDie.getPips()).isEqualTo(4);
    }

    @Test(expectedExceptions = {NullPointerException.class},
          expectedExceptionsMessageRegExp = "^Random is null$")
    public void testRandomIsNotNull() {
        new Die(null);
    }

    @Test
    public void testRollOf6() {
        //Stub of the Collaborator
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };

        Die die = new Die(random); //Subject Under Test
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(6);
    }

    @Test
    public void testIntegrationWithRealRandom() {
        Die die = new Die(new Random()); //Subject Under Test
        for (int i= 0; i < 1000000; i++) {
            assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
        }
    }

    @Test
    public void testBUG3010() {
        Random random = createMock(Random.class);

        //Rehearse
        expect(random.nextInt(6)).andReturn(4);

        //Replay/Rewind
        replay(random);

        //Test
        Die die = new Die(random); //Subject Under Test
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(5);

        //Verify
        verify(random);
    }
}
