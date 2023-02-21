package com.test.murali;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;


public class FirstSelenium {

    WebDriver driver;

    //JavascriptExecutor js;
    @BeforeMethod
    public void init(){
        driver=new ChromeDriver();
        System.setProperty("Webdriver.chrome.driver","/Users/muralic/Desktop/selenium/driver/chromedriver");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        // Here will compare if test is failing then only it will enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
// Create refernce of TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;

// Call method to capture screenshot
                File source = ts.getScreenshotAs(OutputType.FILE);

// Copy method  specific location here it will save all screenshot in our project home directory and
// result.getName() will return name of test case so that screenshot name will be same
                try {
                    String home = System.getProperty("user.dir");
                    File f=new File(home+File.separator+"screenshot"+File.separator);
                    FileHandler.copy(source, new File(f+ result.getName() + ".png"));
                    System.out.println("Screenshot taken");
                } catch (Exception e) {
                    System.out.println("Exception while taking screenshot " + e.getMessage());
                }
            }catch (Exception e){}
            driver.quit();
        }
    }
    @Test(enabled = false)
    public void tetSelenium(){

        driver.get("https://www.geeksforgeeks.org/");
        WebElement java = driver.findElement(
                By.xpath("(//li/a[text()='Java'])[3]"));


        // Create a reference
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //refeesh browser:
       js.executeScript("location.reload()");

        JavascriptExecutor js1 = (JavascriptExecutor)driver;

        //Call the JavascriptExecutor methods
       // js.executeScript("arguments[0].click();", java);
    }

    @Test(enabled = false)
    public void scrolldownDemo() throws InterruptedException {
        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
        Thread.sleep(5000);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(5000);
        WebElement lastModifiedColHeader = driver.findElement(By.xpath("//*[@id=\"md-inline-widget\"]/div/span/a[604]"));
                //findElement(By.xpath("//*[@id='md-inline-widget']/div/span/a[604]"));
        js.executeScript("arguments[0].scrollIntoView();", lastModifiedColHeader);
        Thread.sleep(5000);
        System.out.println(element.getText());

    }

    @Test(enabled = false)
    public void scrolltoViewDemo() throws InterruptedException {
        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
        JavascriptExecutor js = (JavascriptExecutor)driver;
//        WebElement lastModifiedColHeader = driver.findElement(By.xpath("//*[@id=\"md-inline-widget\"]/div/span/a[604]"));
//        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"md-inline-widget\"]/div/span/a[604]")));
        js.executeScript("window.scrollBy(1000,0)", "");
        Thread.sleep(5000);
    }

    @Test
    public void captureScreenShotOnFailure(){
        driver.get("http://www.facebook.com");
        driver.findElement(By.xpath("//input[@id=\"email12\"]")).sendKeys("Learn Automation");

    }
}
