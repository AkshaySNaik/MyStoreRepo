package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegisteredPage {

	WebDriver ldriver;

	public UserRegisteredPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@class='account']//span[1]")
	WebElement accountName;

	@FindBy(id = "search_query_top")
	WebElement searchbox;

	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchbutton;

	@FindBy(linkText = "Sign out")
	WebElement signout;

	public String getAccountUserName() {

		String text = accountName.getText();
		return text;
	}

	public boolean displayedRegisteredUserName() {

		boolean registeredname = accountName.isDisplayed();
		return registeredname;
	}

	public void enterSearchBox(String text) {

		searchbox.sendKeys(text);
	}

	public TShirtPage clickTShirtSearchButton() {

		searchbutton.click();
		return (new TShirtPage(ldriver));
	}

	public DressesPage clickDressSearchButton() {

		searchbutton.click();
		return (new DressesPage(ldriver));

	}

	public IndexPage clickSignOut() {

		signout.click();
		return (new IndexPage(ldriver));

	}

}
