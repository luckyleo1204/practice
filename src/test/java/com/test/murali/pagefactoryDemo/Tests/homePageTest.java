package com.test.murali.pagefactoryDemo.Tests;

import com.test.murali.pagefactoryDemo.pages.dashboard;
import com.test.murali.pagefactoryDemo.pages.homePage;
import com.test.murali.pagefactoryDemo.pages.loginPage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class homePageTest {

    RemoteWebDriver driver = null;
    public String username = "Luckyleo1204";
    public String accesskey = "QOu27JPc12nxn1I6v26nRYQP1l3CTvMUjt0cdhwDpueEoxeQ9k";
    public String gridURL = "@hub.lambdatest.com/wd/hub";

    @BeforeClass
    public void setup() {

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("110.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "Luckyleo1204");
        ltOptions.put("accessKey", "QOu27JPc12nxn1I6v26nRYQP1l3CTvMUjt0cdhwDpueEoxeQ9k");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

//        ChromeOptions capabilities = new ChromeOptions();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("version", "latest");
//        capabilities.setCapability("platform", "Windows 10");
//        capabilities.setCapability("build", "[Java] Page Factory Demo on LambdaTest");
//        capabilities.setCapability("name", "[Java] Page Factory Demo on LambdaTest");
//        capabilities.setCapability("geoLocation", "IN");
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void homePageTest() {
        homePage home = new homePage(driver);
       loginPage lp=home.startTest();
      dashboard db=lp.enterLoginDetails();

    }

    @AfterClass
    public void tearDown() {
        System.out.println("Close method of WebDriver Called");
        driver.close();
    }
}