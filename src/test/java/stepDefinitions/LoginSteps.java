package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.becow.actions.HomePage;

import CommonPage.CommonTestCase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends CommonTestCase {
	WebDriver driver;
	HomePage homePage;
	String user = "genymotionios";

	public LoginSteps() {
		driver = CommonTestCase.driver;
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@Given("^I navigate to Beecow link and click on Login button$")
	public void iNavigateToBeecowLinkAndClickOnLoginButton() {
		homePage.clickLoginMenu();
	}

	@When("^I input email \"(.*?)\"$")
	public void iInputEmail(String arg1) {
		homePage.inputUsername(arg1);
	}

	@When("^I input password \"(.*?)\"$")
	public void iInputPassword(String arg1) {
		homePage.inputPass(arg1);
	}

	@When("^I click to submit account$")
	public void iClickToSubmitAccount() {
		homePage.clickLoginBTN();
	}

	@Then("^Verify successfully with name on profile setting \"(.*?)\"$")
	public void verifySuccessfullyWithNameOnProfileSetting(String arg1) {
		try {
			verifyEqual(homePage.getTextUser(), user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
