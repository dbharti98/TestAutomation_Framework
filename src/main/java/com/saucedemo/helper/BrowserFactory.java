package com.saucedemo.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

    private BrowserFactory() {
    }

    public enum BrowsersEnum {
        FIREFOX("FIREFOX"), CHROME("CHROME"), INTERNETEXPLORER("IE");

        private final String browser;

        BrowsersEnum(String browser) {
            this.browser = browser;
        }

        public String getBrowserName() {
            return browser;
        }
    }

    public static WebDriver getWebDriverForBrowser(String browser) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        if (browser != null) {
            if (browser.equalsIgnoreCase(BrowsersEnum.FIREFOX.getBrowserName())) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            } else if (browser.equalsIgnoreCase(BrowsersEnum.CHROME.getBrowserName())) {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            } else if (browser.equalsIgnoreCase(BrowsersEnum.INTERNETEXPLORER.getBrowserName())) {
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            }
        }
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}