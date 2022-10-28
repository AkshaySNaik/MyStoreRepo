package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccountPage;
import com.mystore.pageobject.UserRegisteredPage;
import com.mystore.utilities.MyXLSReader;
import com.mystore.utilities.ReadXlsxFile;

public class TC_LogOutTest extends BaseClass {

	@Test(dataProvider = "dataSupplier", groups = "Smoke", enabled = true)
	public void logOutTest(HashMap<String, String> hMap) {

		if (!ReadXlsxFile.isRunnable(xlsreader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Skipped Due To RunMode Set To N");
		}

		IndexPage indxpg = new IndexPage(driver);
		MyAccountPage accntpg = indxpg.clickSignIn();

		accntpg.enterRegisteredEmail(hMap.get("Username"));
		accntpg.enterRegisteredPassword(hMap.get("Password"));
		UserRegisteredPage userregpg = accntpg.clickToRegisteredLogin();

		String expectedResult = hMap.get("ExpectedResult");
		boolean convertedExpectedResult = false;

		if (expectedResult.equalsIgnoreCase("Success")) {

			convertedExpectedResult = true;

		} else if (expectedResult.equalsIgnoreCase("Failure")) {

			convertedExpectedResult = false;
		}

		boolean actualResult = false;
		
		try {
			
		IndexPage indexpg = userregpg.clickSignOut();

		String indexTitle = indexpg.getIndexTitle();
		
		if(indexTitle.equalsIgnoreCase("Login - My Store")) {
			
			actualResult = true;		
		}
		
	 }catch(Throwable e) {
		 
		 actualResult = false;	 		 
	 }
		Assert.assertEquals(actualResult, convertedExpectedResult);

	}

	
	@DataProvider(name = "dataSupplier")
	public Object[][] dataSupplier() {

		Object[][] data = null;

		try {

			String path = System.getProperty("user.dir") + "//TestDatas//TutorialsNinja.xlsx";
			xlsreader = new MyXLSReader(path);
			data = ReadXlsxFile.getTestData(xlsreader, "LoginTest", "Data");

		} catch (Throwable e) {

			e.printStackTrace();
		}

		return data;
	}

}
