package com.saucedemo.feature.pages.home;

import com.codoid.products.fillo.Recordset;
import com.saucedemo.feature.locators.home.HomePageLocators;
import com.saucedemo.util.ExcelUtil;
import com.saucedemo.utilities.ExtentTestManager;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends HomePageLocators {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waitForDomToLoad();
    }

    public boolean verifyHomePageLogoDisplayed() {
        return isDisplayed(homePageLogo);
    }

    public void openMenuBar() {
        click(menuIcon);
        ExtentTestManager.ReporterLog("Clicked on menu bar");
    }

    public void verifyListOfAllMenus() throws Exception {
        List<String> allExpectedItems = new ArrayList<>();
        List<String> allActualItems = getTextArray(allMenuItems);
        ExtentTestManager.ReporterLog(allActualItems+" All Actual Menu Items");

        Recordset recordset = ExcelUtil.getTestData("HomePageData");
        while (recordset.next()) {
            allExpectedItems.add(recordset.getField("All_Menus"));
        }
        ExtentTestManager.ReporterLog(allExpectedItems+" All Expected Menu Items");

        Assert.assertEquals(allActualItems, allExpectedItems,
                "All menu items are not matching as expected");
    }

    public void clickAddProductToCart(String expectedText){
        click(addToCartButton);
        Assert.assertEquals(getText(cartProductCountText),expectedText,"Products count is not correct");
        ExtentTestManager.ReporterLog(getText(cartProductCountText)+" actual cart product count");
        ExtentTestManager.ReporterLog(expectedText+" expected cart product count");
    }

    public void productInCartPage(List<String> expectedText){
        if(getText(cartProductCountText).equalsIgnoreCase(expectedText.toString())){
            click(cartProductCountText);
            List<String> allActualItemsOnCartPage = getTextArray(productItemOnCartPage);
            Assert.assertEquals(allActualItemsOnCartPage, expectedText,
                    "selected products are not matching as expected in cart");
            ExtentTestManager.ReporterLog(allActualItemsOnCartPage + " actual product's on cart page");
            ExtentTestManager.ReporterLog(expectedText+" expected product's on cart page");
        }
    }

    public void removePrdFromCartPage(){
        waitForDomToLoad();
        waitForVisible(removeItem);
        click(removeItem);
    }
}