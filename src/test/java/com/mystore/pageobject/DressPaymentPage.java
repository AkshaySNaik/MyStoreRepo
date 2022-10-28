package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressPaymentPage {

	WebDriver ldriver;

	public DressPaymentPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@class='cheque']")
	WebElement cashPayment;

	public DressPaymentConfPage clickCashPay() {

		cashPayment.click();
		return (new DressPaymentConfPage(ldriver));
	}

}
