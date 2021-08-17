package com.zebrunner.dummy.e02;

import com.zebrunner.agent.core.annotation.Maintainer;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Feature: test maintainer on a class and method level
 */
@Maintainer("admin")
public class TestMaintainerSuite {

    @Test(testName = "First test")
    public void test01() {
        assertTrue(Boolean.TRUE);
    }

    @Test
    public void test02() {
        assertTrue(Boolean.TRUE);
    }

    @Test(testName = "Third test")
    @Maintainer("newuser3")
    public void test03() {
        assertTrue(Boolean.TRUE);
    }

}
