package com.saucedemo.feature.pages.login;

import com.saucedemo.helper.AppUserUtility;
import com.saucedemo.feature.locators.login.LoginPageLocators;
import com.saucedemo.feature.pages.home.HomePage;
import com.saucedemo.utilities.ExtentTestManager;
import org.openqa.selenium.WebDriver;

public class LoginPage extends LoginPageLocators {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(userName).isDisplayed();
    }

    public LoginPage waitForPageToLoad() {
        waitForVisible(userName);
        waitForVisible(password);
        return this;
    }

    public LoginPage enterUserNamePassword(AppUserUtility.Users user) {
        enterUserName(AppUserUtility.getUserName(user))
                .enterPassword(AppUserUtility.getPassword(user));
        return this;
    }

    public LoginPage enterUserName(String userEmail) {
        waitForPageToLoad();
        enterText(userName, userEmail);
        ExtentTestManager.ReporterLog("Enter Username in username field");
        return this;
    }

    public LoginPage enterPassword(String userPassword) {
        waitForPageToLoad();
        enterText(password, userPassword);
        ExtentTestManager.ReporterLog("Enter Password in password field");
        return this;
    }

    public HomePage clickOnLoginButton() {
        waitForPageToLoad();
        click(loginButton);
        ExtentTestManager.ReporterLog("Click on login button");
        return new HomePage(driver);
    }

    public HomePage loginUser() {
        if (System.getProperty("user").equalsIgnoreCase("1")) {
            enterUserNamePassword(AppUserUtility.Users.USER_1);
            ExtentTestManager.ReporterLog("Logged in as " + AppUserUtility.Users.USER_1 + " user");
        } else if (System.getProperty("user").equalsIgnoreCase("DataDev")) {
            enterUserNamePassword(AppUserUtility.Users.USER_2);
            ExtentTestManager.ReporterLog("Logged in as " + AppUserUtility.Users.USER_2 + " user");
        }
        clickOnLoginButton();
        return new HomePage(driver);
    }
}