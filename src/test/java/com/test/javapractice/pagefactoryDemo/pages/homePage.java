package com.test.javapractice.pagefactoryDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class homePage {

    private RemoteWebDriver driver;
    private static String PAGE_URL = "https://www.lambdatest.com";
    @FindBy(xpath = "(//form/input[@name=\"email\"])[1]")
    public WebElement email;
    @FindBy(xpath = "//button[.='Start Free Testing']")
    public WebElement startFreeTestingButton;

    public homePage(RemoteWebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        Assert.assertTrue(driver.getCurrentUrl().startsWith(PAGE_URL));
        // homePage sample_page = PageFactory.initElements(driver, homePage.class);
        PageFactory.initElements(driver, this);
    }

    public loginPage startTest() {
        email.sendKeys("luckyleo1204@gmail.com");
        startFreeTestingButton.click();
        return new loginPage(driver);
    }
}
