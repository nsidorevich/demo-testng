package com.zebrunner.dummy.e11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Test with custom retry analyzer. Analyzer will attempt to retry test up to 3 times.
 */
public class TestWithRetries {

    private static final Logger log = LoggerFactory.getLogger(TestWithRetries.class);

    @DataProvider(name = "numbers-provider")
    public Object[][] numbers() {
        return new Object[][] { { 1 }, { 2 }, { 3 } };
    }

    // if test will always fail on 2. 3 retries will be made, resulting in 4 total attempts
    @Test(dataProvider = "numbers-provider", retryAnalyzer = CustomRetryAnalyzer.class)
    public void testWithDP(int number) {
        boolean result = number == 2 ? Boolean.FALSE : Boolean.TRUE;

        // we should see this log 4 times
        log.info("Trying to evaluate number: {}", number);

        assertTrue(result);
    }

}
