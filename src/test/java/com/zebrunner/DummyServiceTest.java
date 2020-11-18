package com.zebrunner;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class DummyServiceTest {

    private static final Random r = new Random();

    @Test(testName = "First")
    public void firstTest() {
        assertTrue(Boolean.TRUE);
    }

    @Test(testName = "Second")
    public void secondTest() {
        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void thirdTest() {
        boolean result = r.nextInt(10) > 5 ? Boolean.TRUE : Boolean.FALSE;
        assertTrue(result);
    }

}
