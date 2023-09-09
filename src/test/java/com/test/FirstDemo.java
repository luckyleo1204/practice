package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstDemo {

    WebDriver driver;

    @BeforeMethod(enabled = true)
     public void init()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @Test(enabled = true)
    public void testDemo1(){
        driver.get("https://www.flipkart.com/");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(200));
       // wait.until(driver.findElement(By.xpath("//div/button[text()='✕']"))).isDisplayed();
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
        driver.findElement(By.name("q")).sendKeys("mobiles");
        driver.findElement(By.xpath("//div/button[text()='✕']")).click();

    }

    @Test(enabled = false)
    public void testcase2(){

    }

    @Test
    public void kushi(){
        for(int i=1;i<=100;i++) {
            for(int j=1;j<=10;j++){
                System.out.print(j*i+"\t");
            }
            System.out.println();
        }
    }



    @AfterMethod(enabled = true)
    public void teardown(){
        driver.quit();
    }
}
