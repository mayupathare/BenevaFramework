package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
	
private WebDriver driver;
//WebDriverWait wait= new WebDriverWait(driver, 30);
	
	private By firstName= By.xpath("//input[contains(@name,'first')]");
	private By lastName= By.xpath("//input[contains(@name,'last')]");
	private By email= By.xpath("//input[@type='email']");
	private By comment = By.xpath("//textarea[@id='wpforms-161-field_2']");
	private By submitButton = By.xpath("//button[@type='submit']");
	private By SuccessMsg = By.xpath("//p[contains(text(),'Thanks for contacting us!')]");
	
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String geContactPageTitle()
	{
		return driver.getTitle();
	}
	public void enterFormDetails(String fName, String lName, String emailID, String msg )
	{
		driver.findElement(firstName).sendKeys(fName);
		driver.findElement(lastName).sendKeys(lName);
		driver.findElement(email).sendKeys(emailID);
		driver.findElement(comment).sendKeys(msg);
	
	}
	
	public void clickSubmitButton() throws InterruptedException
	{
		driver.findElement(submitButton).click();
		Thread.sleep(5000);
		
	}
	public String verifyMessage()
	{
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(SuccessMsg)));
		String actualMsg= driver.findElement(SuccessMsg).getText();
		return actualMsg;
	}
	
	

}
