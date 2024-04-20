package com.saucedemo.feature.locators.home;

import com.saucedemo.helper.BaseHelp;
import org.openqa.selenium.By;

/**
 * This class contains Home Page related locators
 */
public class HomePageLocators extends BaseHelp {
    public By homePageLogo = By.xpath("//div[@class='app_logo']");
    public By menuIcon = By.id("react-burger-menu-btn");
    public By allMenuItems = By.xpath("//div[@class='bm-menu']//a");
    public By addToCartButton = By.xpath("//button[text()='Add to cart']");
    public By cartProductCountText = By.xpath("//span[@class='shopping_cart_badge']");
    public By productItemOnCartPage = By.xpath("//div[@class='cart_item']");
    public By removeItem = By.id("remove-sauce-labs-backpack");
}
