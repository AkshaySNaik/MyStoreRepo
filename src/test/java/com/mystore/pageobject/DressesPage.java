package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage {
	
	
	WebDriver ldriver;
	
	public DressesPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath = "//a[@class='product_img_link']//img[1]")
	WebElement actionDress;
	
	
	@FindBy(css = "li[class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered'] "
			+ "a[title='View'] span")
	WebElement clickDressMore;
	
	
	
	public void actionOnDressImg() {
		
		Actions action = new Actions(ldriver);
		action.moveToElement(actionDress).build().perform();	
	}
	
	
	public DressesResultPage clickDressMore() {
		
		clickDressMore.click();
		return (new DressesResultPage(ldriver));
		
	}
	
	
	
	
	
	

}
