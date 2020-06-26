import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Util.Variables.*;

public class ParameterTest {

    WebDriver driver;

    @BeforeTest
    public void initialization4() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
    }

    @Test
    @Parameters({"uid", "pwd"})
    public void VerifyLoginPageWithParameter(String uid, String pwd)
    {
        driver.findElement(By.name("uid")).sendKeys(uid);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.name("btnLogin")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Guru99 Bank Manager HomePage";
        try {
            Assert.assertEquals(expectedTitle, actualTitle);
        } catch(AssertionError e) {
            driver.switchTo().alert().sendKeys("Incorrect login credentials");
        }
    }

    @AfterTest
    public void endProgram4() {
        driver.quit();      //https://sqa.stackexchange.com/a/25850
    }
}
