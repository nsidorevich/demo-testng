package com.zebrunner.dummy.e06;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

/**
 * Test with invocation count. Disabled test (#4)
 */
public class TestWithInvocationCountAndDisabled {

    private static final Random r = new Random();

    @Test(testName = "First")
    public void firstTest() {
        assertTrue(Boolean.TRUE);
    }

    @Test(testName = "Second")
    public void secondTest() {
        assertTrue(Boolean.TRUE);
    }

    /**
     * This test will randomly fail
     */
    @Test(invocationCount = 3)
    public void thirdTest() {
        boolean result = r.nextInt(10) > 5 ? Boolean.TRUE : Boolean.FALSE;
        assertTrue(result);
    }

    /**
     * This test is not going to be reported
     */
    @Test(enabled = false) // not going to be reported
    public void fourthTest() {
        assertTrue(Boolean.TRUE);
    }

}
