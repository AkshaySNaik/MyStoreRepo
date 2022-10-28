package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreation {

	WebDriver ldriver;
	
	public AccountCreation(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="id_gender1")
	WebElement genderRadioButton;
	
	@FindBy(id="customer_firstname")
	WebElement custfirstName;
	
	@FindBy(css="input[id='customer_lastname']")
	WebElement custlastName;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="days")
	WebElement dropDownDobDate;
	
	@FindBy(id="months")
	WebElement dropDownDobMonth;
	
	@FindBy(id="years")
	WebElement dropDownDobYear;
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(name="company")
	WebElement companyDetail;
	
	@FindBy(id="address1")
	WebElement adress;
	
	@FindBy(id="address2")
	WebElement adressSec;
	
	@FindBy(name="city")
	WebElement cityOne;
	
	@FindBy(id="id_state")
	WebElement dropDownState;
	
	@FindBy(id="postcode")
	WebElement stateCode;
	
	@FindBy(id="id_country")
	WebElement dropDownCountry;
	
	@FindBy(id="other")
	WebElement additionalInfo;
	
	@FindBy(id="phone")
	WebElement homePhone;
	
	@FindBy(id="phone_mobile")
	WebElement mobileNumber;
	
	@FindBy(id="alias")
	WebElement aliasAddress;
	
	@FindBy(id="submitAccount")
	WebElement submitButton;
	
	public void clickRadioGender1() {
		genderRadioButton.click();
	}
	
	public void enterCustFirstName(String fname) {
		custfirstName.sendKeys(fname);
	}
	
	public void enterCustLastName(String lname) {
		custlastName.sendKeys(lname);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void selectDobDate(int indexNo) {
		Select select = new Select(dropDownDobDate);
		select.selectByIndex(indexNo);	
	}
	
	public void selectDobMonth(int indexNo) {
		Select select = new Select(dropDownDobMonth);
		select.selectByIndex(indexNo);	
	}
	
	public void selectDobYear(int indexNo) {
		Select select = new Select(dropDownDobYear);
		select.selectByIndex(indexNo);
	}
	
	public void enterFirstName(String fName) {
		firstName.clear();
		firstName.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		lastName.clear();
		lastName.sendKeys(lName);
	}
	
	public void enterCompanyDetail(String compDetail) {
		companyDetail.sendKeys(compDetail);
	}
	
	public void enterAddress(String address) {
		adress.sendKeys(address);
	}
	
	public void enterAddressSec(String addressSec) {
		adressSec.sendKeys(addressSec);
	}
	
	public void enterCity(String city) {
		cityOne.sendKeys(city);
	}
	
	public void selectState(String state) {
		Select select = new Select(dropDownState);
		select.selectByVisibleText(state);
	}
	
	public void enterStateCode(String code) {
		stateCode.sendKeys(code);
	}
	
	public void selectCountry(String contry) {
		Select select = new Select(dropDownCountry);
		select.selectByVisibleText(contry);
	}
	
	public void enterAdditinalInfo(String addInfo) {
		additionalInfo.sendKeys(addInfo);
	}
	
	public void enterHomeNumber(String homeNumber) {
		homePhone.sendKeys(homeNumber);
	}
	
	public void enterMobileNumber(String mobileNum) {
		mobileNumber.sendKeys(mobileNum);
	}
	
	public void enterAliasAddress(String aliAddress) {
		aliasAddress.clear();
		aliasAddress.sendKeys(aliAddress);
	}
	
	public UserRegisteredPage clickSubmit() {
		submitButton.click();
		return (new UserRegisteredPage(ldriver));
	}
	
}
