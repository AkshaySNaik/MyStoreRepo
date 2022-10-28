package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressOrderConfirmationPage {

	WebDriver ldriver;

	public DressOrderConfirmationPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement confrmmessg;

	@FindBy(xpath = "//img[@alt='My Store']")
	WebElement clicklog;

	public String getOrderConfirmMessage() {

		return confrmmessg.getText();
	}

	public void clickToHomeLogo() {

		clicklog.click();
	}

}
