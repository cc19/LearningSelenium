package stepImplementation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class BDDloginTest {

    WebDriver driver;

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page");
    }

    @When("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password() {
        System.out.println("user enters correct username and correct password");
    }

    @Then("^User gets confirmation$")
    public void User_gets_confirmation() {
        System.out.println("User gets confirmation");
    }
}
