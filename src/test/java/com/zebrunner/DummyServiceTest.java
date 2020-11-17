package com.zebrunner;

import com.zebrunner.agent.core.annotation.Maintainer;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Maintainer("admin")
public class DummyServiceTest {

    @Test(testName = "Test #1")
    public void firstTest() {
        assertTrue(Boolean.TRUE);
    }

    @Test()
    @Maintainer("anonymous")
    public void secondTest() {
        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void thirdTest() {
        assertTrue(Boolean.TRUE);
    }

}
