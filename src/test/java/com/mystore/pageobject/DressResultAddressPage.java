package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressResultAddressPage {
	
	WebDriver ldriver;
	
	public DressResultAddressPage(WebDriver rdiver) {
		
		ldriver = rdiver;
		PageFactory.initElements(rdiver, this);
		
	}
	
	@FindBy(xpath = "//button[@name='processAddress']//span[1]")
	WebElement procedcheckout;
	
	
	public DressShippingPage clickProceedCheckOut() {
		
		procedcheckout.click();
		return (new DressShippingPage(ldriver));
	}
	
	

}
