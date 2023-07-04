package com.test.javapractice;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class crosBrowser {
    WebDriver driver;
    Workbook wb;
    Sheet sh1;
    int numrow;
    String username;
    String password;
    @Test(dataProvider="testdata")
    public void TestFireFox(String uname,String password1)
    {

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(uname);
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password1);
    }
    @DataProvider(name="testdata")
    public Object[][] TestDataFeed(){

//        try {
//
//// load workbook
//            wb=Workbook.getWorkbook(new File("location of excel sheet/fbdata.xls"));
//
//// load sheet in my case I am referring to first sheet only
//           // sh1= wb.getSheet(0);
//
//// get number of rows so that we can run loop based on this
//            numrow=  sh1.getRows();
//        }
//        catch (Exception e)
//
//        {
//            e.printStackTrace();
//        }
//
//// Create 2 D array and pass row and columns
//        Object [][] facebookdata=new Object[numrow][sh1.getColumns()];
//
//// This will run a loop and each iteration  it will fetch new row
//        for(int i=0;i<numrow;i++){
//
//// Fetch first row username
//            facebookdata[i][0]=sh1.getCell(0,i).getContents();
//// Fetch first row password
//            facebookdata[i][1]=sh1.getCell(1,i).getContents();
//
//        }
//
//// Return 2d array object so that test script can use the same
       return null;
    }
}
