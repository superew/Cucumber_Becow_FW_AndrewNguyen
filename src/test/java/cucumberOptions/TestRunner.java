package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/java/features/Feature03_EditCustomer.feature", monochrome = true, glue = { "stepDefinitions" },tags = {"@LogInGuruBank,@CreateCustomer" })
@CucumberOptions(features = "src/test/java/features", monochrome = true, glue = { "stepDefinitions" },tags = {"@LogInBeeCow" })


public class TestRunner {

}
