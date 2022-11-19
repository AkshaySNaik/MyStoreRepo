package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.testcases.BaseClass;

public class ExtentListenerClass extends BaseClass implements ITestListener {

	ExtentSparkReporter htmlReport;
	ExtentReports report;
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttestthread = new ThreadLocal<ExtentTest>();

	public void configureReport() {

		ReadConfigFiles configfile = new ReadConfigFiles();

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String reportname = "MyStoreReport" + timestamp + ".html";

		String reportPath = System.getProperty("user.dir") + "//Reports//" + reportname;
		htmlReport = new ExtentSparkReporter(reportPath);
		htmlReport.config().setDocumentTitle("My Store Report");
		htmlReport.config().setReportName("My Store Test Report");
		htmlReport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Machine", "TestPC01");
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		report.setSystemInfo("Browser", configfile.getExcelBrowsers());
		report.setSystemInfo("User Name", System.getProperty("user.name"));

	}

	@Override
	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On Start Invoced");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish Invoced");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Methods Started :" + result.getName());
		test = report.createTest(result.getName());
		extenttestthread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed :" + result.getName());
		extenttestthread.get().log(Status.PASS,
				MarkupHelper.createLabel("Test Passed : " + result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed :" + result.getName());
		extenttestthread.get().log(Status.FAIL,
				MarkupHelper.createLabel("Test Failed :" + result.getName(), ExtentColor.RED));

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		captureScreenshot(driver, result.getName());

		String screenshotpath = System.getProperty("user.dir") + "//Screenshots//" + result.getName() + ".png";
		File file = new File(screenshotpath);
		if (file.exists()) {

			extenttestthread.get().fail("Failed Test Screenshot " + extenttestthread.get().addScreenCaptureFromPath(screenshotpath));
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped :" + result.getName());
		extenttestthread.get().log(Status.SKIP,
				MarkupHelper.createLabel("Test Skipped :" + result.getName(), ExtentColor.YELLOW));
	}

}
