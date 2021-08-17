package com.zebrunner.dummy.e07;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

/**
 * Test with data provider and test with random result (again)
 */
public class TestWithDataProvider {

    private static final Random r = new Random();

    @Test()
    public void testWithRandomResult() {
        boolean result = r.nextInt(10) > 5 ? Boolean.TRUE : Boolean.FALSE;
        assertTrue(result);
    }

    @DataProvider(name = "numbers-provider")
    public Object[][] numbers() {
        return new Object[][] { { 1 }, { 2 }, { 3 } };
    }

    // this test will always fail with 2 being passed
    /**
     * Line number will be part of the test. Workarounds? Discuss
     */
    @Test(dataProvider = "numbers-provider")
    public void testWithDP(int number) {
        boolean result = number == 2 ? Boolean.FALSE : Boolean.TRUE;
        assertTrue(result);
    }

}
