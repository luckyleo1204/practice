package com.test.murali;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class seleniumTests {
   public  WebDriver driver;
   
   @BeforeMethod
   public void init(){
       System.setProperty("webdriver.chrome.driver","/Users/muralic/Desktop/selenium/driver/chromedriver");
       ChromeOptions opts=new ChromeOptions();
       opts.addArguments("--remote-allow-origins=*");
       driver=new ChromeDriver(opts);
   }
    @Test(enabled = true)
    public void SeleniumPract() throws IOException {
         driver.get("http://www.google.com");
         driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(),"Google");
        Assert.assertTrue(driver.getTitle().contains("Goog"));
        Assert.assertTrue(driver.getTitle().startsWith("G"));
        Assert.assertTrue(driver.getTitle().endsWith("e"));

         List<WebElement> elements=driver.findElements(By.tagName("a"));
         List<String> finalelements=new ArrayList<>();
         for(WebElement i : elements){
             finalelements.add(i.getAttribute("href"));
         }
        System.out.println(finalelements.size());

         for(String j:finalelements){
             System.out.println("Link:"+j+"=>"+linkStatus(new URL(j)));
         }
    }

    public static String linkStatus(URL url) throws IOException {String status="";
       HttpURLConnection connection= (HttpURLConnection) url.openConnection();
       status=connection.getResponseMessage();
       connection.disconnect();
       return status;

    }

    @Test(enabled = true)
    public void guru99(){
        driver.get("https://www.guru99.com");
        driver.manage().window().maximize();
        List<WebElement> elements=driver.findElements(By.xpath("//h4/b[text()='Testing']/following::ul[1]/li"));
        elements.forEach(n-> System.out.println(n.getText()));
    }

    @Test(enabled = true)
    public void guru99Following(){
       driver.get("https://demo.guru99.com/v1/");
       List<WebElement> elements=driver.findElements(By.xpath("//input[@name=\"uid\"]/following::input"));
       elements.forEach(n-> System.out.println(n.getAttribute("name")));
    }

    @Test(enabled = true)
    public void guru99Preceding(){
        driver.get("https://demo.guru99.com/v1/");
        List<WebElement> elements=driver.findElements(By.xpath("//input[@name=\"btnReset\"]/preceding::input"));
        elements.forEach(n-> System.out.println(n.getAttribute("name")));
    }

    @Test(enabled = true)
    public void guru99Example2(){
       driver.get("https://www.guru99.com/");
       List<WebElement> elements=driver.findElements(By.xpath("//h2/strong[text()='Popular Tools']/following::div[@class=\"wp-block-kadence-rowlayout alignnone rotatenativeads99\"]"));
       elements.forEach(n-> System.out.print(n.getText()+"\t"));
    }

    @Test(enabled = true)
    public void googleSearch(){
       driver.get("https://www.google.com/");
       driver.manage().window().maximize();
       driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Selenium");
       List<WebElement> elements=driver.findElements(By.xpath("(//ul[@role=\"listbox\"])[1]"));
       elements.forEach(n-> System.out.print(n.getText()+"\t"));
    }

    @Test(enabled = true)
    public void googleSearch1(){
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Set<String> win=driver.getWindowHandles();
        for(String i: win){
            System.out.println(i);
            driver.switchTo().window(i).close();
        }
    }
    @AfterMethod
    public void teardown(){
       driver.quit();
    }
}
