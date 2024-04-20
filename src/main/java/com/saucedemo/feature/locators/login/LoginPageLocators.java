package com.saucedemo.feature.locators.login;

import com.saucedemo.helper.BaseHelp;
import org.openqa.selenium.By;

/**
 * This class contains Login Page related locators
 */
public class LoginPageLocators extends BaseHelp {
    public By userName = By.name("user-name");
    public By password = By.name("password");
    public By loginButton = By.id("login-button");
}
