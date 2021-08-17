package com.zebrunner.dummy.e09;

import com.zebrunner.agent.core.registrar.Label;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Test with a test factory
 */
import static org.testng.Assert.assertTrue;

public class TestFactory {

    private final int value;

    public TestFactory(int value) {
        this.value = value;
    }

    @Test
    public void test() {
        Label.attachToTest("value", String.valueOf(value));
        boolean result = value > 5 ? Boolean.TRUE : Boolean.FALSE;
        assertTrue(result);
    }

    @Factory
    public static Object[] factoryMethod() {
        Object[] tests = new Object[10];
        for (int i = 1; i <= 10; i++) {
            tests[i - 1] = new TestFactory(i);
        }
        return tests;
    }

}
