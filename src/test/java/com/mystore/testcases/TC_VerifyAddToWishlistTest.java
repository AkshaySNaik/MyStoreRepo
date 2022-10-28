package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.TShirtPage;
import com.mystore.pageobject.UserRegisteredPage;

public class TC_VerifyAddToWishlistTest extends BaseClass {

	@Test(groups = "Smoke", enabled = true)
	public void verifyAddWishList() {

		IndexPage indexpg = new IndexPage(driver);
		indexpg.enterSearchBox("T-Shirt");
		TShirtPage tshirtpg = indexpg.clickTShirtSearchButton();

		tshirtpg.actionHoverOnTshirt();
		tshirtpg.clickAddToWishList();
		String message = tshirtpg.getWishListErrorMess();

		Assert.assertEquals(message, "You must be logged in to manage your wishlist.");

	}

}
