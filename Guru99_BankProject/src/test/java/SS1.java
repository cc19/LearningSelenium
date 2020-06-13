import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SS1 {

    public static void main(String[] args) {
        SS1 ss1Obj = new SS1();
        ss1Obj.VerifyLoginPage();
    }

    public void VerifyLoginPage()
    {
        WebDriver driver =  new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.demo.guru99.com/V4/");

        WebElement uidTxt = driver.findElement(By.name("uid"));
        WebElement pwdTxt = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.name("btnLogin"));

        uidTxt.sendKeys("mngr265692");
        pwdTxt.sendKeys("amApUbu");
        loginBtn.click();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.close();
    }
}
