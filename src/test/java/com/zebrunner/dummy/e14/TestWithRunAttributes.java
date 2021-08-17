package com.zebrunner.dummy.e14;

import com.zebrunner.agent.core.registrar.CurrentTestRun;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Attrubutes set can be attached to run programmatically: build and locale
 */
public class TestWithRunAttributes {

    @BeforeClass
    public void beforeClass() {
        CurrentTestRun.setBuild("v1.2.3");
    }

    @Test(testName = "First test")
    public void test01() {
        CurrentTestRun.setLocale("en_US");

        assertTrue(Boolean.TRUE);
    }

}
