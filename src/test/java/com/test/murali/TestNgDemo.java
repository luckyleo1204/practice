package com.test.murali;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestNgDemo {

    WebDriver driver;

    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver","/Users/muralic/Desktop/selenium/driver/chromedriver");
        ChromeOptions opts=new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(opts);

    }

    @Test(retryAnalyzer = retryAnalyzer.class)
    public void Test1(){
        System.out.println("this is retry method");
        Assert.assertTrue(false);

       Set<Object> s=new HashSet<>();

    }

    @AfterClass
    public void teardown() {
        TestNG runner = new TestNG();
        List<String> al = new ArrayList<String>();
        //add the testng-failed.xml to list     
        al.add("C:\\NewWorkSpace\\TesttNgEx\\test-output\\SuiteTest\\testng-failed.xml");
        //set as list to setTestSuites
        runner.setTestSuites(al);
        //Execute using run() , method.
        runner.run();
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        // The number of times data is repeated, test will be executed the same no. of times
        // Here it will execute two times
        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
    }

    @Test(dataProvider = "Authentication")
    public void test(String sUsername, String sPassword) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.store.demoqa.com");
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        // Argument passed will be used here as String Variable
        driver.findElement(By.id("log")).sendKeys(sUsername);
        driver.findElement(By.id("pwd")).sendKeys(sPassword);
        driver.findElement(By.id("login")).click();
        driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
        driver.quit();

    }


}

