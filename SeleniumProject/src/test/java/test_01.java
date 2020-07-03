
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class test_01 {

    @Test
    public void Test_01() {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\cc1\\Documents\\software\\geckodriver-v0.26.0-win64\\geckodriver.exe");
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
