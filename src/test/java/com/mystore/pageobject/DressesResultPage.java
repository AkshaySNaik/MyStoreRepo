package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DressesResultPage {

	WebDriver ldriver;
	
	public DressesResultPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id = "quantity_wanted")
	WebElement dresqty;
	
	@FindBy(id = "group_1")
	WebElement selectqty;
	
	@FindBy(xpath = "//button[@name='Submit']//span[1]")
	WebElement cart;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']//span[1]")
	WebElement prck;
	
	
	
	public void enterdressQty(String nos) {
		
		dresqty.clear();
		dresqty.sendKeys(nos);
	}
	
	public void selectDressSize(String text) {
		
		Select select = new Select(selectqty);
		select.selectByVisibleText(text);
	}
	
	public void addDressToCart() {
		
		cart.click();
	}
	
	public DressResultSignInPage clickProceedCheckout() {
		
		prck.click();
		return (new DressResultSignInPage(ldriver));
	}
	
	
	
}
