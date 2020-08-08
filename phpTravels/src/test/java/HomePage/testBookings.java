package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testBookings {

    static WebDriver driver;

    @BeforeMethod
    public void loadPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/cc1/Documents/software/chromedriver");
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/home");
        Thread.sleep(3000);
    }


//    public static void toursBooking() throws InterruptedException {
//        //tours tab
//        driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[3]/a")).click();
//        //Destination
//        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/div/div[3]/div/div/form/div/div/div[1]/div/div[2]/div/a/span[1]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/ul/li[3]/div")).click();
//        //Tour type
//        Select tourType = new Select(driver.findElement(By.id("tourtype")));
//        tourType.selectByVisibleText("Family");
//        //driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/div/div/div/div/form/div/div/div[2]/div/div/div/div/div[2]/div/a/span")).click();
//        //Date
//        driver.findElement(By.id("DateTours")).sendKeys("15/08/2020");
//        //Number of adults
//        driver.findElement(By.name("adults")).sendKeys("2");
//        //Search button
//        driver.findElement(By.xpath("//*[@id=\"hotels\"]/div/div/form/div/div/div[4]/button")).click();
//    }

    @Test
    public static void hotelBooking() throws InterruptedException {
        //hotels tab
        driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[1]/a")).click();
        //destination
        WebElement dest = driver.findElement(By.className("select2-chosen"));
        dest.click();
        Thread.sleep(2000);
        dest.sendKeys("Alzer Hotel Istanbul, Istanbul");
        //driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/ul/li[1]/div")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
