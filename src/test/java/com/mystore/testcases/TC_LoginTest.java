package com.mystore.testcases;

import java.io.IOException;
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

public class TC_LoginTest extends BaseClass {
	
	 

	@Test(dataProvider = "dataSender", enabled = true)
	public void registeredSignIn(HashMap<String, String> hMap) throws IOException {

		if (!ReadXlsxFile.isRunnable(xlsreader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Skipped Due To Run Mode Set To N");
		}

		//setBrowserByExcel(hMap.get("Browser"));

		IndexPage indexpg = new IndexPage(driver);
		MyAccountPage accountpg = indexpg.clickSignIn();
		log.info("Clicked On Sign In Button");
		accountpg.enterRegisteredEmail(hMap.get("Username"));
		log.info("Entered Registered Email Address");
		accountpg.enterRegisteredPassword(hMap.get("Password"));
		log.info("Entered Registered Password");
		UserRegisteredPage accpg = accountpg.clickToRegisteredLogin();

		String expectedresult = hMap.get("ExpectedResult");
		boolean convertedexpresult = false;

		if (expectedresult.equals("Success")) {

			convertedexpresult = true;

		} else if (expectedresult.equals("Failure")) {

			convertedexpresult = false;
		}

		boolean actualResult;

		try {

			actualResult = accpg.displayedRegisteredUserName();

			accpg.clickSignOut();

		} catch (Throwable e) {

			actualResult = false;
		}
		
		Assert.assertEquals(actualResult, convertedexpresult);
	}
	

	
	@DataProvider(name = "dataSender")
	public Object[][] dataSender() {

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
