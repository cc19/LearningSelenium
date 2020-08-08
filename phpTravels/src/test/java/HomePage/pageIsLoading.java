package HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class pageIsLoading {

    static WebDriver driver;

    public static void main(String[] args) {
        openPage();
    }

    public static void openPage() {
        System.setProperty("webdriver.chrome.driver", "/home/cc1/Documents/software/chromedriver");
        driver =  new ChromeDriver();
        driver.get("https://www.phptravels.net/home");
    }

    public void tearDown() {
        driver.quit();
    }
}
