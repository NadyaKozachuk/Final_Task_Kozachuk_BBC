package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class CoronavirusPage extends BasePage {

    private static final By HOW_TO_SHARE = By.xpath("//div[contains(@class,'nw-c-5-slice')]//h3[contains(text(),'How to share')]");

    public CoronavirusPage clickToHowToShare() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(findElement(HOW_TO_SHARE)).click().build().perform();
        return new CoronavirusPage();
    }

}
