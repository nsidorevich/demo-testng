package com.zebrunner.dummy.e10;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.registrar.Label;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Tests with dependencies
 * Skipped tests tracking
 */
public class TestsWithDependencies {

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
        assertTrue(Boolean.FALSE);
    }

    @Test(dependsOnMethods = "thirdTest")
    @TestLabel(name = "test", value = "test-val") // will be attached
    public void fourthTest() {
        Label.attachToTest("label", "depends-on-3rd"); // not gonna be attached, since test body never executed
        assertTrue(Boolean.TRUE);
    }

    @Test(dependsOnMethods = "secondTest")
    public void fifthTest() {
        Label.attachToTest("label", "depends-on-2nd");
        assertTrue(Boolean.TRUE);
    }

}
