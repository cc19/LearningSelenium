import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static Util.Variables.*;

public class ParameterTest2 {

    WebDriver driver;

    @BeforeMethod
    public void initialization4() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
    }

    @AfterMethod
    public void endProgram4() {
        driver.quit();
    }

    @DataProvider(name="param2")
    public static Object[][] creds()
    {
        return new Object[][] {{username,password}, {"username",password}, {username,"password"}, {"username","password"}};
    }

    @Test(dataProvider = "param2")
    public void testCreds(String uname, String pass)
    {
        driver.findElement(By.name("uid")).sendKeys(uname);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("btnLogin")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Guru99 Bank Manager HomePage";
            Assert.assertEquals(expectedTitle, actualTitle);
    }
}
