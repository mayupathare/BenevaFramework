package stepdefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.ContactPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ContactPageSteps {
	
	private ContactPage contactPage=new ContactPage(DriverFactory.getDriver());

@Given("User is on Contact Page")
public void user_is_on_contact_page() {
	
	  DriverFactory.getDriver().get("https://practicetestautomation.com/contact/");
    
}

@When("User fills the details from given sheetname {string} and rownumber {int}")
public void user_fills_the_details_from_given_sheetname_and_rownumber(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
	ExcelReader reader= new ExcelReader();
	List<Map<String,String>> testData= reader.getData("C:\\Users\\mayuri.pathare\\Documents\\AutomationData.xlsx", sheetName);
	String fName= testData.get(rowNum).get("FirstName");
	String lName= testData.get(rowNum).get("LastName");
	String emailID= testData.get(rowNum).get("Email");
	String comment =testData.get(rowNum).get("Message");
	contactPage.enterFormDetails(fName, lName, emailID, comment);
   
}

@When("User clicks on Submit button")
public void user_clicks_on_submit_button() throws InterruptedException {
	contactPage.clickSubmitButton();
}

@Then("message will be displayed as {string}")
public void message_will_be_displayed_as(String expectedMsg) {
   String actualMsg= contactPage.verifyMessage();
   System.out.println("Success Message is: "+ actualMsg);
   Assert.assertEquals(expectedMsg, actualMsg);
}

}
