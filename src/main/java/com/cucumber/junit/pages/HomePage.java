package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final String BBC_URL = "https://www.bbc.com";

    private static final By NEWS_BUTTON = By.xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]");

    public void openBBCHomePage() {
        DriverManager.getDriver().get(BBC_URL);
    }

    public void clickNewsButton() {
        findElement(NEWS_BUTTON).click();
    }
}



