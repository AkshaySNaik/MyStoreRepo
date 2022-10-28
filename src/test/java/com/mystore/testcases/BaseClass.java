package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;


import com.mystore.utilities.MyXLSReader;
import com.mystore.utilities.ReadConfigFiles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfigFiles config = new ReadConfigFiles();

	String url = config.getUrl();
	String browser = config.getBrowser();

	public static WebDriver driver;
	public static Logger log;
	public static MyXLSReader xlsreader;

	@BeforeClass(enabled = true)
	public void setUp() {

		// Browser Selection By Switch Case
		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			driver = null;
			break;
		}

		// Maximize the Window
		driver.manage().window().maximize();

		// Applying Implicitly Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Creating log object reference
		log = LogManager.getLogger(BaseClass.class.getName());

		// Navigate to URL page
		driver.get(url);
		log.info("Url Opened");

	}

	@AfterClass(enabled = true)
	public void tearDown() {
		// Quit All The Windows
		driver.quit();
	}
	
	
	
	public String randomlyGetStringValue() {
		
		return RandomStringUtils.randomAlphabetic(5);
	}

	
	
	public void captureScreenshot(WebDriver driver, String testname){

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			
			String path = System.getProperty("user.dir") + "//Screenshots//" + testname + ".png";
			FileUtils.copyFile(screenshot, new File(path));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
	public void setBrowserByExcel(String browser) {

		// Browser Selection By Switch Case
		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			driver = null;
			break;
		}

		// Maximize the Window
		driver.manage().window().maximize();

		// Applying Implicitly Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Creating log object reference
		log = LogManager.getLogger(BaseClass.class.getName());

		// Navigate to URL page
		driver.get(url);
		log.info("Url Opened");

	}

}
