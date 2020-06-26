package stepDefinitions;

import Utilities.Variables;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BDDLoginTest {

    WebDriver driver;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver = new FirefoxDriver();
        driver.get(Variables.baseURL);
        System.out.println("User is on the login page");
    }

    @When("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password() {
        System.out.println("user enters correct username and correct password");
        driver.findElement(By.name("uid")).sendKeys(Variables.username);
        driver.findElement(By.name("password")).sendKeys(Variables.password);
        driver.findElement(By.name("btnLogin")).click();
    }

    @When ("^user enters email (.*)$")
    public void user_enters_username(String username)
    {
        driver.findElement(By.name("uid")).sendKeys(username);
    }

    @And ("^user enters password (.*)$")
    public void user_enters_password(String password)
    {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And ("^user clicks submit button$")
    public void user_clicks_submit()
    {
        driver.findElement(By.name("btnLogin")).click();
    }

    @Then("^user gets confirmation$")
    public void user_gets_confirmation() {
        System.out.println("user gets confirmation");
        String expectedTitle = "Guru99 Bank Manager HomePage";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
