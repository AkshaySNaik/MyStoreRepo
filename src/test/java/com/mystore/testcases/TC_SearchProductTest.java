package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccountPage;
import com.mystore.pageobject.TShirtPage;
import com.mystore.pageobject.UserRegisteredPage;

public class TC_SearchProductTest extends BaseClass {

	@Test(groups = "Smoke", enabled = true)
	public void searchProduct() throws InterruptedException {

		IndexPage indexpg = new IndexPage(driver);
		MyAccountPage accountpg = indexpg.clickSignIn();

		accountpg.enterRegisteredEmail("akshaysnaik224488@gmail.com");
		accountpg.enterRegisteredPassword("A88615a*");
		UserRegisteredPage registerpg = accountpg.clickToRegisteredLogin();

		registerpg.enterSearchBox("T-Shirt");
		TShirtPage tshirtpg = registerpg.clickTShirtSearchButton();

		boolean actualresult = false;

		try {

			actualresult = tshirtpg.tshirtDisplayed();
			registerpg.clickSignOut();

		} catch (Throwable e) {

			actualresult = false;
		}
		if (actualresult == true) {

			Assert.assertEquals(actualresult, true);
			log.info("Test Passed");
			Assert.assertTrue(actualresult);

		} else {

			log.info("Test Failed");
			captureScreenshot(driver, "searchProduct");
			Assert.assertTrue(actualresult);
		}
	
		
	}

}
