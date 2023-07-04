package com.test.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.TestNGAntTask.Mode.testng;

public class demo {

    @Test(retryAnalyzer = retryAnalyzer.class)
    public void demo11(){
        Assert.assertTrue(false);
    }

    @Test()
    public void demo12(){
        Assert.assertTrue(false);
    }
}
