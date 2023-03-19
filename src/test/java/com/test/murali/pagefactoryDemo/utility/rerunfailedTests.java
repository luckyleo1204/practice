package com.test.murali.pagefactoryDemo.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class rerunfailedTests implements IRetryAnalyzer {

    private int retrycount=0;
    private static final int maxount=5;

    public boolean retry(ITestResult result){
        if(retrycount<maxount){
            retrycount++;
            return true;
        }
        return  false;
    }
}
