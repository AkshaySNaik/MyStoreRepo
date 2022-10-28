package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.pageobject.DressOrderConfirmationPage;
import com.mystore.pageobject.DressPaymentConfPage;
import com.mystore.pageobject.DressPaymentPage;
import com.mystore.pageobject.DressResultAddressPage;
import com.mystore.pageobject.DressResultSignInPage;
import com.mystore.pageobject.DressShippingPage;
import com.mystore.pageobject.DressesPage;
import com.mystore.pageobject.DressesResultPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccountPage;
import com.mystore.pageobject.UserRegisteredPage;

public class TC_BuyProductTest extends BaseClass{
	
	@Test(groups = "Smoke",enabled = true)
	public void buyProductTest() {
		
		IndexPage indexpg = new IndexPage(driver);
		MyAccountPage accountpg = indexpg.clickSignIn();
		
		accountpg.enterRegisteredEmail("akshaysnaik224488@gmail.com");
		accountpg.enterRegisteredPassword("A88615a*");
		UserRegisteredPage userregpg = accountpg.clickToRegisteredLogin();
		
		userregpg.enterSearchBox("Dresses");
		DressesPage dresspg = userregpg.clickDressSearchButton();
		
		dresspg.actionOnDressImg();
		DressesResultPage dressresultpg = dresspg.clickDressMore();
		
		dressresultpg.enterdressQty("2");
		dressresultpg.selectDressSize("S");
		dressresultpg.addDressToCart();
		DressResultSignInPage dressresultsign = dressresultpg.clickProceedCheckout();
		
		DressResultAddressPage dressadresspg = dressresultsign.clickProceedCheckOut();
		
		DressShippingPage dressshipg = dressadresspg.clickProceedCheckOut();
		
		dressshipg.clickCheckBox();
		DressPaymentPage dresspaypg = dressshipg.clickProceedCheckOut();

		DressPaymentConfPage dressConfPg = dresspaypg.clickCashPay();
		
		DressOrderConfirmationPage dressfinalconf = dressConfPg.clickConfirmButton();
		
		dressfinalconf.clickToHomeLogo();
		
		userregpg.clickSignOut();

		
	}
	
	

}
