import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static Util.Variables.*;

public class chromeCheck {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.navigate().to("https://www.glassdoor.co.in/Interview/Capgemini-Selenium-Testing-Interview-Questions-EI_IE3803.0,9_KO10,26.htm");
        driver.manage().window().maximize();
        //System.out.println("Beginning of test");
    }

    @Test(enabled = false)
    public void test() {
        System.out.println("This is a test");
        String s1 = new String("HELLO");
        String s2 = new String("HELLO");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s= new String("Hello");
        s.concat("Java");
        System.out.println(s);
    }

    @Test
    public void getLabelText() {
       // String lblTxt = driver.findElement(By.xpath("//*[@id=\"InterviewReview_16133789\"]/div[3]/div/div[2]/div[2]/div/div[2]/ul/li[5]/span")).getText();
        //System.out.println(lblTxt);

        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        driver.switchTo().frame(0);
    }

    @AfterTest
    public void tearDown() {
        try {
            Thread.sleep(50000);
        } catch(InterruptedException e) {
            System.out.println("Closed soon/late");
        }

        driver.close();
    }



}
