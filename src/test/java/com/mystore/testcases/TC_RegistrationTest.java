package com.mystore.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreation;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccountPage;
import com.mystore.pageobject.UserRegisteredPage;
import com.mystore.utilities.MyXLSReader;
import com.mystore.utilities.ReadXlsxFile;

public class TC_RegistrationTest extends BaseClass {

	
	
	@Test(dataProvider = "dataSupplier", enabled = false)
	public void newRegistration(HashMap<String,String> hMap) throws IOException {
		
		if(!ReadXlsxFile.isRunnable(xlsreader, "RegisterTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			
			throw new SkipException("Test Skipped Due To Run Mode Set To N");
		}
		
		setBrowserByExcel(hMap.get("Browser"));

		IndexPage indexpg = new IndexPage(driver);
		MyAccountPage accountpg = indexpg.clickSignIn();
		log.info("Clicked On Sign In Button");

		accountpg.enterEmailAddress(hMap.get("Email"));
		log.info("Entered Email Address");
		AccountCreation accountcreation = accountpg.clickSubmitButton();
		log.info("Clicked On Submit Button");
		
		String expectedResult = hMap.get("ExpectedResult");
		boolean convertedExpectedResult = false;
		
		if(expectedResult.equalsIgnoreCase("Success")) {
			
			convertedExpectedResult = true;	
			
		}else if(expectedResult.equalsIgnoreCase("Failure")) {
			
			convertedExpectedResult = false;	
		}
		
		log.info("Registration Details Applied");
		accountcreation.clickRadioGender1();
		accountcreation.enterCustFirstName(hMap.get("FirstName"));
		accountcreation.enterCustLastName(hMap.get("LastName"));
		accountcreation.enterPassword(hMap.get("Password"));
		accountcreation.selectDobDate(8);
		accountcreation.selectDobMonth(2);
		accountcreation.selectDobYear(11);
		accountcreation.enterFirstName(hMap.get("FirstName1"));
		accountcreation.enterLastName(hMap.get("LastName1"));
		accountcreation.enterCompanyDetail(hMap.get("Company"));
		accountcreation.enterAddress(hMap.get("Address"));
		accountcreation.enterAddressSec(hMap.get("Address1"));
		accountcreation.enterCity(hMap.get("City"));
		accountcreation.selectState(hMap.get("State"));
		accountcreation.enterStateCode(hMap.get("Poatal No."));
		accountcreation.selectCountry(hMap.get("Country"));
		accountcreation.enterAdditinalInfo(hMap.get("Additional Info"));
		accountcreation.enterHomeNumber(hMap.get("Telephone"));
		accountcreation.enterMobileNumber(hMap.get("Mobile Phone"));
		accountcreation.enterAliasAddress(hMap.get("Address Alias"));
		UserRegisteredPage registeredpage = accountcreation.clickSubmit();
		log.info("Registration Details Completed");

		boolean actualResult = false;
		
		try {
			
	    if(registeredpage.getAccountUserName().equals(hMap.get("FirstName")+" "+hMap.get("LastName"))) {
	    	actualResult = true;
	    }
	    registeredpage.clickSignOut();	
		log.info("Verifying the Result");
		
		}catch(Exception e) {
			
			actualResult = false;		
		}
		
		Assert.assertEquals(actualResult, convertedExpectedResult);	
		
	}

	
	@DataProvider(name="dataSupplier")
	public Object[][] dataSupplier(){
		
		Object[][] data = null;
		 
		try {
			
	    xlsreader = new MyXLSReader("TestDatas//TutorialsNinja.xlsx");
	    data = ReadXlsxFile.getTestData(xlsreader, "RegisterTest","Data" );
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return data;	
	}
	
}
