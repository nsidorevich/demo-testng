package com.zebrunner.dummy.e13;

import com.zebrunner.agent.core.registrar.CurrentTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * APU allowing programmatically skip or revert test registration based on some predicate (or not using predicate)
 */
public class SkippableTest {

    @DataProvider(name = "numbers-provider")
    public Object[][] numbers() {
        return new Object[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
    }

    // if test will always fail on 2. 3 retries will be made, resulting in 4 total attempts
    @Test(dataProvider = "numbers-provider")
    public void testWithDP(int number) {
        if (number % 2 == 0) {
            // only tests with even numbers will not be registered
            CurrentTest.revertRegistration();
        }
        assertTrue(Boolean.TRUE);
    }

}
