import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeTest {

    @Test
    public void ChromeGoogleTest() {
        System.setProperty("webdriver.chrome.driver", "/home/cc1/Documents/software/chromedriver");
        WebDriver driver = new ChromeDriver();
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
