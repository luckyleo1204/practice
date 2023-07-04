package com.test.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryWithRetryAnnotationDemo {

    @Test
    @RetryCountIfFailed(10)
    public void test1(){
        Assert.assertTrue(false);
    }

    @Test()
    public void test2(){
        Assert.assertTrue(false);
    }

}


