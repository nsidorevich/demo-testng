package com.zebrunner.dummy.e01;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 *
 * 1. Configuration precedence<p>
 * 2. Suite name override<p>
 * 3. Project key<p>
 *
 * Simple tests with dummy assertions
 *
 * Features: test name override. REPORTING_RUN_ENVIRONMENT=OVERRIDE
 */
public class SimpleTest {

    @Test(testName = "First test")
    public void test01() {
        assertTrue(Boolean.TRUE);
    }

    @Test
    public void test02() {
        assertTrue(Boolean.TRUE);
    }

    @Test(testName = "Third test")
    public void test03() {
        assertTrue(Boolean.TRUE);
    }

    @Test
    public void test04() {
        assertTrue(Boolean.FALSE);
    }

    @Test(testName = "Fifth test")
    public void test05() {
        assertTrue(Boolean.TRUE);
    }

}
