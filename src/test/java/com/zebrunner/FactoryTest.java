package com.zebrunner;

import com.zebrunner.agent.core.registrar.Label;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FactoryTest {

    private final int value;

    public FactoryTest(int value) {
        this.value = value;
    }

    @Test
    public void test() {
        Label.attach("value", String.valueOf(value));
        boolean result = value > 5 ? Boolean.TRUE : Boolean.FALSE;
        assertTrue(result);
    }

    @Factory
    public static Object[] factoryMethod() {
        Object[] tests = new Object[10];
        for (int i = 1; i <= 10; i++) {
            tests[i - 1] = new FactoryTest(i);
        }
        return tests;
    }

}
