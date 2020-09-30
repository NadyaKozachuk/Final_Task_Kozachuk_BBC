package com.cucumber.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.cucumber.junit.driver.DriverManager.getDriver;

public class BasePage {

    private static final By SIGN_IN_TO_NEWS_LATER_BUTTON = By.xpath("//button[contains(@class,'sign_in-exit')]");

    public BasePage() {

        PageFactory.initElements(getDriver(), this);
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static WebElement findElement(By by) {
        return getDriver().findElement(by);
    }


    public void clickSignInLaterPopup() {
        findElement(SIGN_IN_TO_NEWS_LATER_BUTTON).click();
    }

    public static List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }
}
