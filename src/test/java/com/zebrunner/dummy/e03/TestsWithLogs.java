package com.zebrunner.dummy.e03;

import com.zebrunner.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test with logs.
 * Workaround for log buffering (fast tests only).
 * Logs filtering
 */
import static org.testng.Assert.assertTrue;

public class TestsWithLogs {

    private static final Logger log = LoggerFactory.getLogger(TestsWithLogs.class);

    // not supported!
    @BeforeClass
    public void beforeClass() {
        log.info("BEFORE CLASS: You won't see me :(");
    }

    // not supported - to be fixed soon
    @BeforeMethod
    public void beforeTest() {
        log.info("BEFORE METHOD: Test execution is about to start...");
    }

    @Test
    public void test01() {
        log.info("I am log from test#1");
        Hooks.waitForCompletion();

        assertTrue(Boolean.TRUE);
    }

    @Test
    public void test02() {
        log.info("I am log from test#2");
        Hooks.waitForCompletion();

        assertTrue(Boolean.TRUE);
    }

    @AfterMethod
    public void afterTest() {
        log.info("AFTER METHOD: here we gooooo!");
    }

}
