package com.test.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzer2 implements IRetryAnalyzer {
    int counter = 0;
    @Override
    public boolean retry(ITestResult result) {

        // check if the test method had RetryCountIfFailed annotation
        RetryCountIfFailed annotation = result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(RetryCountIfFailed.class);
        // based on the value of annotation see if test needs to be rerun
        if((annotation != null) && (counter < annotation.value()))
        {
            counter++;
            return true;
        }
        return false;
    }

}
