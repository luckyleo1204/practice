package com.test.murali.pagefactoryDemo.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class dashboard {
    private RemoteWebDriver driver;

    public dashboard(RemoteWebDriver driver){
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        PageFactory.initElements(driver,this);
    }

}
