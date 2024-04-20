package com.saucedemo.helper;

import org.openqa.selenium.WebDriver;

public class BrowserUtil {

	public static WebDriver driver;

	private BrowserUtil() {
	}

	public static WebDriver getBrowser() {
		if (driver == null) {
			driver = BrowserFactory.getWebDriverForBrowser(System.getProperty("browser"));
		}
		return driver;
	}

	public static void quitWebDriver() {
		if (driver != null) {
			driver.quit();
			driver=null;
		}
	}
}