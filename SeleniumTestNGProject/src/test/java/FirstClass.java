import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirstClass {

    @Test
    public void LoginTest() {
        System.setProperty("webdriver.gecko.driver","/home/cc1/Documents/software/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Maven Central");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Maven Central")) {
            System.out.println("Search successful");
        }
        driver.close();
    }
}
