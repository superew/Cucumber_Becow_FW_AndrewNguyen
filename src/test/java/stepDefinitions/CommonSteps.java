package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.becow.actions.CommonPage;

import CommonPage.CommonTestCase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CommonSteps extends CommonTestCase {
	CommonPage commonPage;
	CommonTestCase commonTestCase;
	WebDriver driver;

	public CommonSteps() {
		driver = CommonTestCase.driver;
		commonPage = PageFactory.initElements(driver, CommonPage.class);
	}

	@Then("^Verify successfully with message \"(.*?)\"$")
	public void verifySuccessfullyWithMessage(String value) {
		verifyTrue(commonPage.isDisplayed(value));
	}

	@Then("^Close browser$")
	public void quitBrowser() {
		CommonTestCase.closeBrowser();

	}

//	@Given("^I open \"(.*?)\" page$")
//	public void i_open_page(String value) {
//		commonPage.openDynamicPage(value);
//	}
}
