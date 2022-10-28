package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	WebDriver ldriver;
	
	public IndexPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="Sign in")
	WebElement signin;
	
	@FindBy(id = "search_query_top")
	WebElement searchbox;
	
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchbutton;
	
	public MyAccountPage clickSignIn() {
		signin.click();
		return (new MyAccountPage(ldriver));
	}

	
	public void enterSearchBox(String text) {

		searchbox.sendKeys(text);
	}
	
	
	public String getIndexTitle() {
		
		return ldriver.getTitle();
	}
	
	public TShirtPage clickTShirtSearchButton() {

		searchbutton.click();
		return (new TShirtPage(ldriver));
	}
	
}
