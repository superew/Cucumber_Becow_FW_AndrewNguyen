@LogInBeeCow 
Feature: 	Login feature 
    			As an automation tester
  				I want a test login function 

@LoginWithValidUsernamePassword
Scenario: Create account, login and verify login successfully 
	Given I navigate to Beecow link and click on Login button
	When I input email "genymotionios@gmail.com" 
	And I input password "1234@abcd"
	And I click to submit account
	Then Verify successfully with name on profile setting "genymotionios"