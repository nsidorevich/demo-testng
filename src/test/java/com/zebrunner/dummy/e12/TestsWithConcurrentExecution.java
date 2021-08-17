package com.zebrunner.dummy.e12;

import com.zebrunner.agent.core.registrar.Label;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Concurrent test execution. Pay attention to test name in Zebrunner!
 */
public class TestsWithConcurrentExecution {

    // may result into SSL issue because of Unirest bug
    @Test(testName = "First", invocationCount = 10, threadPoolSize = 5)
    public void firstTest() {
        Label.attachToTest("thread", Thread.currentThread().getName());
        assertTrue(Boolean.TRUE);
    }

}
