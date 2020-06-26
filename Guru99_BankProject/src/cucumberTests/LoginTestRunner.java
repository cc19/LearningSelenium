package cucumberTests;

import org.junit.runner.RunWith;
import cucmber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = "stepImplementation")
public class LoginTestRunner {

}
