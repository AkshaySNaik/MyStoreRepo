package com.mystore.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver ldriver;

	public MyAccountPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "email_create")
	WebElement emailAddress;

	@FindBy(id = "SubmitCreate")
	WebElement submitButton;
	
	@FindBy(id="email")
	WebElement emaill;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement loginButton;
	

	public void enterEmailAddress(String email) {
		emailAddress.sendKeys(email);
	}

	public AccountCreation clickSubmitButton() {
		submitButton.click();
		return (new AccountCreation(ldriver));
	}
	
	public void enterRegisteredEmail(String email) {
		emaill.sendKeys(email);
	}
	
	public void enterRegisteredPassword(String passw) {
		password.sendKeys(passw);
	}
	
	public UserRegisteredPage clickToRegisteredLogin() {
		loginButton.click();
		return (new UserRegisteredPage(ldriver));
	}	
}
