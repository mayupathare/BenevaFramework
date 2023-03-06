package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By userName= By.id("username");
	private By Password= By.id("password");
	private By submitButton= By.id("submit");
	private By loginMsg = By.xpath("//*[text()='Logged In Successfully']");
	private By logoutButton = By.xpath("//*[text()='Log out']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void enterUserName(String username)
	{
		driver.findElement(userName).sendKeys(username);
	}
	public void enterPassword(String pwd)
	{
		driver.findElement(Password).sendKeys(pwd);
	}
	public void clickSubmitButton()
	{
		driver.findElement(submitButton).click();
	}
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyUserLoggedinSuccess()
	{
		boolean Msg =driver.findElement(loginMsg).isDisplayed();
		System.out.println("Login Suceesful Message: "+driver.findElement(loginMsg).getText());
		return Msg;
	}
	public void clickLogoutButton()
	{
		driver.findElement(logoutButton).click();
	}
}
