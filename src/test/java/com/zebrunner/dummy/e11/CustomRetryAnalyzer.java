package com.zebrunner.dummy.e11;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryAnalyzer implements IRetryAnalyzer {

    private int count = 3;

    @Override
    public boolean retry(ITestResult result) {
        // retry 3 times
        return count-- > 0;
    }

}