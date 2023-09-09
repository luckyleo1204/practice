package com.test.javapractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class seleniumTests {
   public  WebDriver driver;
   
   @BeforeMethod
   public void init(){
//       System.setProperty("webdriver.chrome.driver","/Users/muralic/Desktop/selenium/driver/chromedriver");
//       ChromeOptions opts=new ChromeOptions();
//       opts.addArguments("--remote-allow-origins=*");
       driver=new ChromeDriver();

   }


   @Test
   public void testDemo(){
       driver.get("https://www.flipkart.com/");
       String title=driver.getTitle();
       System.out.println(title);

   }

   @Test
   public void flipkart() throws InterruptedException {
       driver.get("https://www.flipkart.com/");
       String title=driver.getTitle();
       System.out.println(title);



       //driver.findElement(By.name("q")).sendKeys("mobiles");

//       driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//       Thread.sleep(5000);
//       driver.findElement(By.xpath("//button[text()='✕']")).click();
//       //List<WebElement> al=driver.findElements(By.xpath("//div[text()='₹65,999']/ancestor::div[@class=\"_1AtVbE col-12-12\"]/div/div/div/a/div[2]/div[@class=\"col col-7-12\"]/div[@class=\"_4rR01T\"]"));
//      // List<WebElement> al=driver.findElements(By.xpath("//div[text()='₹65,999']/ancestor::a[@target=\"_blank\"]/div[2]/div/div[@class=\"_4rR01T\"]"));
//       List<WebElement> al=driver.findElements(By.xpath("//div[text()='₹72,999' < 50000]/parent::a[@class='_1fQZEK']/div[2]/div/div[@class='_4rR01T']"));
//       for(WebElement i : al)
//           System.out.println(i.getText());
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

    @Test(enabled = true)
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

    @Test(alwaysRun = true)
    public void googleSearch1(){
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Set<String> win=driver.getWindowHandles();
        for(String i: win){
            System.out.println(i);
            driver.switchTo().window(i).close();
        }
    }

    @Test(enabled=true)
    public void rediffTest(){
       driver.get("https://money.rediff.com/gainers");
       driver.manage().window().maximize();
       List<WebElement> al=driver.findElements(By.xpath("//table/tbody/tr/td[2][text()='XT']/preceding-sibling::td"));
        System.out.println(al.size());
       al.forEach(n-> System.out.println(n.getText()));
    }

    @Test(enabled=true)
    public void crickSixGreaterThanzero(){
        driver.get("https://www.espncricinfo.com/series/australia-in-india-2022-23-1348637/india-vs-australia-1st-odi-1348656/live-cricket-score");
        driver.manage().window().maximize();
        List<WebElement> al=driver.findElements(By.xpath("//table/tbody[@class=\"ds-text-right\"]/tr/td[5][text()>0]/preceding-sibling::td/a/span"));
        System.out.println(al.size());
        al.forEach(n-> System.out.println(n.getText()));

    }

    @Test(enabled = false)
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

    @Test
    public void testxpath(){
       //driver.get("https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
       driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
       WebElement crossMark=driver.findElement(By.xpath("//div/span[text()=\"✕\"]"));
       wait.until(ExpectedConditions.visibilityOf(crossMark));
        crossMark.click();
        WebElement searchBox= driver.findElement(By.xpath("//input[@name=\"q\"]"));
        searchBox.sendKeys("iphone");
        wait.until(ExpectedConditions.visibilityOf(searchBox));
      searchBox.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
       List<WebElement> al= driver.findElements(By.xpath("//div[text()='₹56,999']/parent::div/parent::div/parent::div/parent::div/div/div[starts-with(text(),'APPLE')]"));
        al.forEach(n-> System.out.println(n.getText()));


    }

    @Test(enabled = false)
    public void getHelperText(){

        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        WebElement flogo=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[1]/img"));
        System.out.println(flogo.getAttribute("title"));
    }

    @Test
    public void uploadFile(){
       driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
       driver.manage().window().maximize();;
      // driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
       driver.findElement(By.xpath("//input[@name=\"photo\"]")).sendKeys("/Users/muralic/Personal/Resume/MuraliC_Testing.docx");
       //driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void teardown(){
       driver.quit();
    }
}
