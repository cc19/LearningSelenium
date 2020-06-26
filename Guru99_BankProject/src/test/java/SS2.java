import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static Util.Variables.*;

public class SS2 {

    WebDriver driver;

    @BeforeTest
    public void initialization2()
    {
        driver =  new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test(priority = 1)
    public void ReVerifyLoginPage()
    {
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        //Thread.sleep(5000);
        driver.findElement(By.name("btnLogin")).click();


    }

    @Test(priority = 2)
    public void VerifyHomePage()
    {
        WebElement heading = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
        String headingText = heading.getText();

        String expectedHeading = "Manger Id : "+username;
        Assert.assertEquals(expectedHeading, headingText);
        System.out.println("Heading check complete");
    }

    @AfterTest
    public void endProgram2()
    {
        driver.close();
    }
}
