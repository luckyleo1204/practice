package com.test.murali;

import org.apache.commons.math3.geometry.partitioning.BoundaryProjection;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderEx {

    @Test(dataProvider = "TestData")
    public void Sum(int a, int b, int result)
    {
            int sum = a + b;
            Assert.assertEquals(result, sum);
    }

    @Test(dataProvider = "TestData")
    public void Diff(int a, int b, int result)
    {
        int diff=a-b;
        Assert.assertEquals(result,diff);
    }
    @DataProvider(name="TestData")
    public Object[][] testdata(Method m)
    {
        switch (m.getName()) {
            case "Sum":
                return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
            case "Diff":
                return new Object[][] {{2, 3, -1}, {5, 7, -2}};
        }
        return null;
    }
}
