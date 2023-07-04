package com.test.javapractice.pagefactoryDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class loginPage {

    private RemoteWebDriver driver;
    @FindBy(xpath = "//input[@id=\"email\"]")
    public WebElement email;
    @FindBy(xpath="//input[@id=\"password\"]")
    public WebElement password;
    @FindBy(xpath= "//button[@id=\"login-button\"]")
    public WebElement loginButton;

    //private static  String Login_PAGE_URL="https://accounts.lambdatest.com/login";


    public loginPage(RemoteWebDriver driver){
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        PageFactory.initElements(driver,this);
    }
    public dashboard enterLoginDetails(){
       // email.clear();
       // email.sendKeys("Luckyleo1204@gmail.com");
        password.sendKeys("Murali@123");
        loginButton.click();
        return new dashboard(driver);
    }
}
