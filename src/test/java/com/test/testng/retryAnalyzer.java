package com.test.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzer implements IRetryAnalyzer {
    int count=0,maxCount=4;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<maxCount){
            count++;
            return true;
        }
        else
            return  false;
    }
}
