package com.xyzcorp;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CalcStatsTest {

    @Test
    public void testMinimumValueWithArrayOfNoItems() {

        try {
            CalcStats.getMinimum(new int[]{});
            fail("This line should not run");
        } catch (IllegalArgumentException iae) {
            assertEquals(iae.getMessage(), "Array length is zero");
        }
    }
    
    @Test
    public void testMinimumValueWithArrayOfOneItem() {
        int result = CalcStats.getMinimum(new int[]{4});
        assertEquals(result, 4);
    }



    @Test
    public void testMinimumThatArrayIsNotNull() {
         try {
        	 CalcStats.getMinimum(null);
        	 fail("This line should not run");
         } catch (NullPointerException npe) {
             assertEquals(npe.getMessage(), "Array is null");        	 
         }
    }

    @Test
    public void testMinimumValueWithArrayOfTwoItems3And4() {
        int result = CalcStats.getMinimum(new int[]{3,4});
        assertEquals(result, 3);
    }

    @Test
    public void testMinimumValueWithArrayOfTwoItems4And3(){
        int result = CalcStats.getMinimum(new int[]{4,3});
        assertEquals(result, 3);
    }

    @Test
    public void testMinimumValueWithANegative() {
    	int result = CalcStats.getMinimum(new int[]{10,-4,3});
    	assertEquals(result, -4);
    }

    @Test
    public void testMinimumValueWithTwosNegativesAndSameValue() {
    	int result = CalcStats.getMinimum(new int[]{10,-4,3,-4});
    	assertEquals(result, -4);
    }

    @Test
    public void testMinimumValueWithManyNegatives() {
    	int result = CalcStats.getMinimum(new int[]{-1000,-333,-1,4,-3,10,-10001});
    	assertEquals(result, -10001);
    }

    
    @Test
    public void testMaximumValueWithArrayOfNoItems() {
        try {
            CalcStats.getMaximum(new int[]{});
            fail("This line should not run");
        } catch (IllegalArgumentException iae) {
            assertEquals(iae.getMessage(), "Array length is zero");
        }
    }

    @Test
    public void testMaximumValueWithArrayOfOneItem() {
        int result = CalcStats.getMaximum(new int[]{4});
        assertEquals(result, 4);
    }

    @Test
    public void testMaximumThatArrayIsNotNull() {
        try {
            CalcStats.getMaximum(null);
            fail("This line should not run");
        } catch (NullPointerException npe) {
            assertEquals(npe.getMessage(), "Array is null");
        }
    }

    @Test
    public void testMaximumValueWithArrayOfTwoItems3And4() {
        int result = CalcStats.getMaximum(new int[]{3,4});
        assertEquals(result, 4);
    }

    @Test
    public void testMaximumValueWithArrayOfTwoItems4And3(){
        int result = CalcStats.getMaximum(new int[]{4,3});
        assertEquals(result, 4);
    }


    @Test
    public void testMaximumValueWithANegative() {
        int result = CalcStats.getMaximum(new int[]{10,-4,3});
        assertEquals(result, 10);
    }
    
    @Test
    public void testNumberOfElements() {
    	int result = CalcStats.getNumberOfElements(new int[]{});
    	assertEquals(result, 0);
    }
    
    @Test
    public void testNumberOfElementsWithArrayOfOneItem() {
    	int result = CalcStats.getNumberOfElements(new int[]{4});
    	assertEquals(result, 1);
    }
   
    @Test(expectedExceptions={NullPointerException.class}, 
    		expectedExceptionsMessageRegExp="^Array is null$")
    public void testNumberOfElementsWithNull() {
    	CalcStats.getNumberOfElements(null);
    }
}







