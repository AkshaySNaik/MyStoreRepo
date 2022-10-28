package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressShippingPage {

	WebDriver ldriver;
	
	public DressShippingPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	
	@FindBy(id = "cgv")
	WebElement clickbox;
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement clickproceedcheckout;
	
	
	public void clickCheckBox() {
		
		clickbox.click();
	}
	
	public DressPaymentPage clickProceedCheckOut() {
		
		clickproceedcheckout.click();
		return (new DressPaymentPage(ldriver));
	}
	
	
	
}
