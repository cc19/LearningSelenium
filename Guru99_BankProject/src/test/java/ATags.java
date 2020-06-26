import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static Util.Variables.baseURL;

public class ATags {

    WebDriver driver;

    @BeforeTest
    public void initialization3()
    {
        driver =  new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void getAtags()
    {
        List<WebElement> li = driver.findElements(By.tagName("a"));
        for(WebElement el:li)
        {
            System.out.println(el.getText());
        }

        System.out.println("Total number of a tagged elements " +li.size());
    }

    @AfterTest
    public void endProgram3()
    {
        driver.close();
    }
}
