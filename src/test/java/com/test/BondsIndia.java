package com.test;

import jdk.security.jarsigner.JarSigner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BondsIndia {

   WebDriver driver;

    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver","/Users/muralic/Desktop/selenium/driver/chromedriver");
        ChromeOptions opts=new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(opts);
    }

    @Test
    public void validatePageHeader(){
        driver.get("https://master.d1cmknsx9mlrhu.amplifyapp.com");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
      //  Assert.assertEquals(driver.getTitle().trim().toString(), "BondsIndia");
        WebElement element=driver.findElement(By.xpath("//input[@placeholder=\"Enter your email\"]"));
        scrolltoView(element);

    }

    @Test
    public void LoginButtonOnHomePage() throws InterruptedException {
        driver.get("https://master.d1cmknsx9mlrhu.amplifyapp.com");
        driver.manage().window().maximize();
        WebElement login=driver.findElement(By.xpath("//div/button[text()='Login']"));
        scrolltoView(login);
        Thread.sleep(5000);
    }

    public void mouseHoverJScript(WebElement HoverElement) {
        try {
            if (isElementPresent(HoverElement)) {

                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',

                true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            ((JavascriptExecutor) driver).executeScript(mouseOverScript,
                    HoverElement);

        } else {
            System.out.println("Element was not visible to hover " + "\n");

        }
    } catch (StaleElementReferenceException e) {
        System.out.println("Element with " + HoverElement
                + "is not attached to the page document"
                + e.getStackTrace());
    } catch (NoSuchElementException e) {
        System.out.println("Element " + HoverElement + " was not found in DOM"
                + e.getStackTrace());
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error occurred while hovering"
                + e.getStackTrace());
    }
}

    public void scrolltoView(WebElement element){
        JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
