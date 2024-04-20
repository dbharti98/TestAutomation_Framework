package com.test.login;

import com.saucedemo.feature.pages.home.HomePage;
import com.saucedemo.feature.pages.login.LoginPage;
import com.saucedemo.util.HelpBase;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends HelpBase {

    HomePage homePage;

    @Test(description = "Verify user can login successfully", priority = 1)
    public void userLogin() {
        LoginPage loginPage = new LoginPage(HelpBase.driver);
        homePage = loginPage.loginUser();
        Assert.assertTrue(homePage.verifyHomePageLogoDisplayed(), "Home Page logo is not displaying");
    }


    @Test(description = "Verify all menu bar options", priority = 2)
    public void menuBar() throws Exception {
        LoginPage loginPage = new LoginPage(HelpBase.driver);
        homePage = loginPage.loginUser();
        Assert.assertTrue(homePage.verifyHomePageLogoDisplayed(), "Home Page logo is not displaying");
        homePage.openMenuBar();
        homePage.verifyListOfAllMenus();
    }


    @Test(description = "Verify product is added successfully in cart and displaying in cart page",
            priority = 3)
    public void addToCart() {
        LoginPage loginPage = new LoginPage(HelpBase.driver);
        homePage = loginPage.loginUser();
        Assert.assertTrue(homePage.verifyHomePageLogoDisplayed(), "Home Page logo is not displaying");

        homePage.clickAddProductToCart("1");
        String a[] = new String[]{"1"};
        homePage.productInCartPage(Arrays.asList(a));
        homePage.removePrdFromCartPage();
    }
}