package com.zebrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DummyServiceTest {

    private static final Logger log = LoggerFactory.getLogger(DummyServiceTest.class);

    // not supported!
    @BeforeClass
    public void beforeClass() {
        log.info("BEFORE CLASS");
    }

    @BeforeMethod
    public void beforeTest() {
        log.info("BEFORE METHOD: Test execution is about to start...");
    }

    // not supported!
    @AfterMethod
    public void afterTest() {
        log.info("AFTER METHOD: Test execution completed");
    }

    @Test(testName = "Test #1")
    public void firstTest() {
        log.info("Doing things: complex assertions, you know...");
        waitHooks();
        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void secondTest() {
        log.info("Info log");


        for (int i = 0; i < 10; i++) {
            log.info("Info log #" + i + " captured at " + System.currentTimeMillis());
        }

        log.debug("Debug log");
        log.trace("Trace log");
        log.warn("Warn log");
        log.error("Oh no!");

        waitHooks();

        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void thirdTest() {
        waitHooks();
        assertTrue(Boolean.FALSE);
    }

    private void waitHooks() {
        try {
            Thread.sleep(1000); // workaround for shutdown hooks issue
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
