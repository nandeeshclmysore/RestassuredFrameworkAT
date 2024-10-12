package org.appu.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int minRetryCount = 0;
    private static final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (minRetryCount < maxRetryCount) {
            minRetryCount++;
            return true;
        }
        return false;
    }
}
