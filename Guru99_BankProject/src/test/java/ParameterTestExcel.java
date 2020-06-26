import Util.Excel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Util.Variables.*;

public class ParameterTestExcel {

    WebDriver driver;

    @BeforeMethod
    public void initialization5() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
    }

    @AfterMethod
    public void endProgram5()
    {
        driver.quit();
    }

    @DataProvider(name="excelParam")
    public static Object[][] loginData()
    {
        return Excel.get("/home/cc1/Documents/github/cc19/LearningSelenium/creds.xls");
    }

    @Test(dataProvider = "excelParam")
    public void loginTest(Object username, Object password) {
        driver.findElement(By.name("uid")).sendKeys((String)username);
        driver.findElement(By.name("password")).sendKeys((String)password);
        driver.findElement(By.name("btnLogin")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Guru99 Bank Manager HomePage";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

}
