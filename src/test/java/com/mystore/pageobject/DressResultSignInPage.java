package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressResultSignInPage {
	
	WebDriver ldriver;
	
	public DressResultSignInPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	 
	}
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[1]")
	WebElement proccedcheckout;
	
	public DressResultAddressPage clickProceedCheckOut() {
		
		proccedcheckout.click();
		return (new DressResultAddressPage(ldriver));
	}
	
}
