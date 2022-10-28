package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TShirtPage {
	
	WebDriver ldriver;
	
	public TShirtPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement tshirtdis;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement homePageLogo;
	
	@FindBy(xpath ="//a[@title='Faded Short Sleeve T-shirts']//img[@title='Faded Short Sleeve T-shirts']")
	WebElement moveontshirt;
	
	@FindBy(xpath = "//a[@class='addToWishlist wishlistProd_1']")
	WebElement addToWishlist;
	
	@FindBy(xpath = "//p[@class='fancybox-error']")
	WebElement wishmessg;
	
	
	public boolean tshirtDisplayed() {
		
		return tshirtdis.isDisplayed();	
	}
	
	public void homePageLogo() {
		
		homePageLogo.click();
	}
	
	public void actionHoverOnTshirt() {
		
		Actions action = new Actions(ldriver);
		action.moveToElement(moveontshirt).build().perform();
	}
	
	public void clickAddToWishList() {
		
		addToWishlist.click();
	}
	
	public String getWishListErrorMess() {
		
		return wishmessg.getText();	
	}
	
}
