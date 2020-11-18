package com.zebrunner;

import com.zebrunner.agent.core.registrar.Label;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DummyServiceTest {

    // may result into SSL issue because of Unirest bug
    @Test(testName = "First", invocationCount = 10, threadPoolSize = 2)
    public void firstTest() {
        Label.attach("thread", Thread.currentThread().getName());
        assertTrue(Boolean.TRUE);
    }

}
