package stepdefinations;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	   DriverFactory.getDriver().get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("User enters username  {string}")
	public void user_enters_username(String userName) {
	  loginPage.enterUserName(userName);
	}

	@When("User enters password  {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("User click on SignIn Button")
	public void user_click_on_sign_in_button() {
		loginPage.clickSubmitButton();
	}

	@Then("User should get title of Page")
	public void user_should_get_title_of_page() {
	   String Title= loginPage.getPageTitle();
	   System.out.println("Page Title is: "+ Title);

	}
	
		@Then("User should be able to Login Successfully")
		public void user_should_be_able_to_login_successfully() {
			loginPage.verifyUserLoggedinSuccess();
		}

@Then("User click on Logout Button")
public void user_click_on_logout_button() {
	loginPage.clickLogoutButton();
}




}
