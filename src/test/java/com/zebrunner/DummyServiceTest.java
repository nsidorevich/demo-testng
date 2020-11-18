package com.zebrunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DummyServiceTest {

    @Test(testName = "First")
    public void firstTest() {
        assertTrue(Boolean.TRUE);
    }

    @DataProvider(name = "numbers-provider")
    public Object[][] numbers() {
        return new Object[][] { { 1 }, { 2 }, { 3 } };
    }

    // if test will fail - try to execute it up to 3 times
    @Test(dataProvider = "numbers-provider", retryAnalyzer = CustomRetryAnalyzer.class)
    public void testWithDP(int number) {
        boolean result = number == 2 ? Boolean.FALSE : Boolean.TRUE;
        assertTrue(result);
    }

}
