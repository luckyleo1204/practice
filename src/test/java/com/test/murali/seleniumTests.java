package com.test.murali;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

import static java.lang.Thread.sleep;

public class seleniumTests {
   public  WebDriver driver;
   
   @BeforeMethod
   public void init(){
       System.setProperty("webdriver.chrome.driver","/Users/muralic/Desktop/selenium/driver/chromedriver");
       ChromeOptions opts=new ChromeOptions();
       opts.addArguments("--remote-allow-origins=*");
       driver=new ChromeDriver(opts);

   }

   @Test
   public void flipkart() throws InterruptedException {
       driver.get("https://www.flipkart.com/");
       driver.findElement(By.name("q")).sendKeys("Apple phone");
       driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
       Thread.sleep(5000);
       driver.findElement(By.xpath("//button[text()='✕']")).click();
       List<WebElement> al=driver.findElements(By.xpath("//div[text()='₹65,999']/ancestor::div[@class=\"_1AtVbE col-12-12\"]/div/div/div/a/div[2]/div[@class=\"col col-7-12\"]/div[@class=\"_4rR01T\"]"));
       for(WebElement i : al)
           System.out.println(i.getText());
   }

   @Test
   public void selectDemo() throws InterruptedException {
       driver.get("https://www.facebook.com/r.php?r=101");
       Thread.sleep(5000);
     WebElement days=driver.findElement(By.id("day"));
       Select select =new Select(days);
       select.selectByIndex(13);
       select.selectByValue("20");
       select.selectByVisibleText("9");
       Thread.sleep(5000);


   }
    @Test(enabled = false)
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

    @Test(enabled = false)
    public void guru99(){
        driver.get("https://www.guru99.com");
        driver.manage().window().maximize();
        List<WebElement> elements=driver.findElements(By.xpath("//h4/b[text()='Testing']/following::ul[1]/li"));
        elements.forEach(n-> System.out.println(n.getText()));
    }

    @Test(enabled = false)
    public void guru99Following(){
       driver.get("https://demo.guru99.com/v1/");
       List<WebElement> elements=driver.findElements(By.xpath("//input[@name=\"uid\"]/following::input"));
       elements.forEach(n-> System.out.println(n.getAttribute("name")));
    }

    @Test(enabled = false)
    public void guru99Preceding(){
        driver.get("https://demo.guru99.com/v1/");
        List<WebElement> elements=driver.findElements(By.xpath("//input[@name=\"btnReset\"]/preceding::input"));
        elements.forEach(n-> System.out.println(n.getAttribute("name")));
    }

    @Test(enabled = false)
    public void guru99Example2(){
       driver.get("https://www.guru99.com/");
       List<WebElement> elements=driver.findElements(By.xpath("//h2/strong[text()='Popular Tools']/following::div[@class=\"wp-block-kadence-rowlayout alignnone rotatenativeads99\"]"));
       elements.forEach(n-> System.out.print(n.getText()+"\t"));
    }

    @Test(enabled = false)
    public void googleSearch(){
       driver.get("https://www.google.com/");
       driver.manage().window().maximize();
       driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Selenium");
       List<WebElement> elements=driver.findElements(By.xpath("(//ul[@role=\"listbox\"])[1]"));
       elements.forEach(n-> System.out.print(n.getText()+"\t"));
    }

    @Test(enabled = false)
    public void googleSearch1(){
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Set<String> win=driver.getWindowHandles();
        for(String i: win){
            System.out.println(i);
            driver.switchTo().window(i).close();
        }
    }

    @Test(enabled = true)
    public void clickElementJS()  {
        driver.get("https://www.browserstack.com/users/sign_in");
        driver.manage().window().maximize();
        JavascriptExecutor js=  (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
        js.executeScript("document.getElementById('user_password').value='password';");
        js.executeScript("document.getElementById('user_submit').click();");
        js.executeScript("alert('enter correct login credentials to continue');");
        //js.executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)");
        //JavascriptExecutor in Selenium to interact with checkbox
       // js.executeScript(“document.getElementByID(‘element id ’).checked=false;”);
        //JavascriptExecutor in Selenium to refresh the browser window
       // js.executeScript(“location.reload()”);
    }

    @AfterMethod
    public void teardown(){
       driver.quit();
    }
}
