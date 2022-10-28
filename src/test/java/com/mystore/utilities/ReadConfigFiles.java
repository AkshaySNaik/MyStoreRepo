package com.mystore.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFiles {

	Properties prop = null;
	String path = "Configration//Config.properties";

	public ReadConfigFiles() {
		prop = new Properties();
		File file = new File(path);

		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getUrl() {
		String url = prop.getProperty("Url");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("URL Not Found In Config File");
		}
	}

	public String getBrowser() {
		String Browser = prop.getProperty("Browser");
		if (Browser != null) {
			return Browser;
		} else {
			throw new RuntimeException("Browser Not Found In Config File");
		}
	}
	
	public String getExcelBrowsers() {
	String excelBrowser = prop.getProperty("AllBrowserUsed");
		if(excelBrowser!=null) {
			return excelBrowser;
		}else {
			throw new RuntimeException("Excel Browser Not Found In Config File");
		}
	}

}
