package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressPaymentConfPage {
	

	WebDriver ldriver;

	public DressPaymentConfPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']//span[1]")
	WebElement  clickconfrmbtton;
	
	public DressOrderConfirmationPage clickConfirmButton() {
		
		clickconfrmbtton.click();
		return (new DressOrderConfirmationPage(ldriver));
	}
	
	

}
