package com.test.javapractice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzer implements IRetryAnalyzer {
     int count=0;
     int maxcount=4;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<maxcount){
            count++;
            return  true;
        }
        return  false;
    }
}
