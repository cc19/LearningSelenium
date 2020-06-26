import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.io.File;

import static Util.Variables.*;

public class SS1 {

    WebDriver driver;
  //  @DataProvider(name = "Authentication")

    @BeforeTest
    public void initialization1()
    {
        driver =  new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void VerifyLoginPage()
    {
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys("password");
        //Thread.sleep(5000);
        driver.findElement(By.name("btnLogin")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Guru99 Bank Manager HomePage";
        try {
            if (!actualTitle.equals(expectedTitle))
            {
                Alert al = driver.switchTo().alert();
                String msg = al.getText();
                al.accept();
            }
        } catch(NoAlertPresentException e) {
            if (actualTitle.equals(expectedTitle))
            {
                System.out.println("Test Passed");
            }
            else
                System.out.println("Test Failed");
        }
    }

  //  @Test(dataProvider = "Authentication")
//    public void VerifyCredentialValidity()
//    {
//        WebElement uid = driver.findElement(By.name("uid"));
//        WebElement pwd = driver.findElement(By.name("password"));
//        WebElement btn = driver.findElement(By.name("btnLogin"));
//
//        uid.sendKeys(username);
//        pwd.sendKeys("password");
//        btn.click();
//
//        //Alert alert = driver.switchTo().alert();
//        //alert.accept();
//    }

    @AfterTest
    public void endProgram1()
    {
        driver.close();
    }

    //    geckodriver issue: https://askubuntu.com/a/871077
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://yizeng.me/2014/04/20/install-chromedriver-and-phantomjs-on-linux-mint/");
 //   }
}
