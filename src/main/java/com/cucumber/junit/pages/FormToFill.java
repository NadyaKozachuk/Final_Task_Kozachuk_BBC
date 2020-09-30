package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class FormToFill extends BasePage{

    private static final By YOUR_STORY_FIELD = By.xpath("//textarea[@placeholder='Tell us your story. ']");
    private static final By YOUR_NAME_FIELD = By.xpath("//div[contains(@class,'input-threeup-leading')]//input[@placeholder='Name']");
    private static final By YOUR_EMAIL_FIELD = By.xpath("//input[@placeholder='Email address']");
    private static final By YOUR_NUMBER_FIELD = By.xpath("//input[@placeholder='Contact number ']");
    private static final By YOUR_LOCATION_FIELD = By.xpath("//input[@placeholder='Location ']");
    private static final By CHECKBOX_NAME = By.xpath("//div[@class='checkbox'][1]//input");
    private static final By CHECKBOX_AGE = By.xpath("//div[@class='checkbox'][2]//input");
    private static final By CHECKBOX_TERMS = By.xpath("//div[@class='checkbox'][3]//input");
    private static final By BUTTON_SUBMIT = By.xpath("//button[@class='button']");
    private static final By STORY_ALERT_MESSAGE = By.xpath("//div[contains(text(),'can')]");
    private static final By NAME_ALERT_MESSAGE = By.xpath("//div[contains(text(),'Name')]");
    private static final By AGE_ALERT_MESSAGE = By.xpath("//div[@class=\"embed-content-container\"]//div[6]//div[contains(text(),'must be accepted')]");
    private static final By INVALID_EMAIL_MESSAGE = By.xpath("//div[contains(text(),'Email address is invalid')]");


    public String verifyURL() {
        return DriverManager.getDriver().getCurrentUrl();

    }

        public String formWithEmptyStoryField() {
            Map<String, String> map = new HashMap<>();
            map.put("story", "storyValue");
            map.put("name", "nameValue");
            map.put("email", "emailValue");
            map.put("number", "numberValue");
            map.put("location", "locationValue");
            findElement(YOUR_NAME_FIELD).sendKeys(map.get("name"));
            findElement(YOUR_EMAIL_FIELD).sendKeys(map.get("email"));
            findElement(YOUR_NUMBER_FIELD).sendKeys(map.get("number"));
            findElement(YOUR_LOCATION_FIELD).sendKeys(map.get("location"));
            findElement(CHECKBOX_NAME).click();
            findElement(CHECKBOX_AGE).click();
            findElement(CHECKBOX_TERMS).click();
            findElement(BUTTON_SUBMIT).click();
            return DriverManager.getDriver().getCurrentUrl();
        }


        public String formWithEmptyNameField() {
        Map<String, String> map = new HashMap<>();
            map.put("story", "storyValue");
            map.put("email", "emailValue");
            map.put("number", "numberValue");
            map.put("location", "locationValue");
            findElement(YOUR_STORY_FIELD).sendKeys("story");
            findElement(YOUR_EMAIL_FIELD).sendKeys(map.get("email"));
            findElement(YOUR_NUMBER_FIELD).sendKeys(map.get("number"));
            findElement(YOUR_LOCATION_FIELD).sendKeys(map.get("location"));
            findElement(CHECKBOX_NAME).click();
            findElement(CHECKBOX_AGE).click();
            findElement(CHECKBOX_TERMS).click();
            findElement(BUTTON_SUBMIT).click();
            return DriverManager.getDriver().getCurrentUrl();
        }

        public String formWithEmptyAgeCheckbox() {
            Map<String, String> map = new HashMap<>();
            map.put("story", "storyValue");
            map.put("name", "nameValue");
            map.put("email", "emailValue");
            map.put("number", "numberValue");
            map.put("location", "locationValue");
            findElement(YOUR_STORY_FIELD).sendKeys("story");
            findElement(YOUR_NAME_FIELD).sendKeys(map.get("name"));
            findElement(YOUR_EMAIL_FIELD).sendKeys(map.get("email"));
            findElement(YOUR_NUMBER_FIELD).sendKeys(map.get("number"));
            findElement(YOUR_LOCATION_FIELD).sendKeys(map.get("location"));
            findElement(CHECKBOX_NAME).click();
            findElement(CHECKBOX_TERMS).click();
            findElement(BUTTON_SUBMIT).click();
            return DriverManager.getDriver().getCurrentUrl();
        }
    public String formWithEmptyTermsCheckbox() {
        Map<String, String> map = new HashMap<>();
        map.put("story", "storyValue");
        map.put("name", "nameValue");
        map.put("email", "emailValue");
        map.put("number", "numberValue");
        map.put("location", "locationValue");
        findElement(YOUR_STORY_FIELD).sendKeys("story");
        findElement(YOUR_NAME_FIELD).sendKeys(map.get("name"));
        findElement(YOUR_EMAIL_FIELD).sendKeys(map.get("email"));
        findElement(YOUR_NUMBER_FIELD).sendKeys(map.get("number"));
        findElement(YOUR_LOCATION_FIELD).sendKeys(map.get("location"));
        findElement(CHECKBOX_NAME).click();
        findElement(BUTTON_SUBMIT).click();
        return DriverManager.getDriver().getCurrentUrl();
    }

        public String formWithInvalidEmail() {
        Map<String, String> map = new HashMap<>();
            map.put("story", "storyValue");
            map.put("name", "nameValue");
            map.put("email", "emailValue");
            map.put("number", "numberValue");
            map.put("location", "locationValue");
            findElement(YOUR_STORY_FIELD).sendKeys("story");
            findElement(YOUR_NAME_FIELD).sendKeys(map.get("name"));
            findElement(YOUR_NUMBER_FIELD).sendKeys(map.get("number"));
            findElement(YOUR_LOCATION_FIELD).sendKeys(map.get("location"));
            findElement(YOUR_EMAIL_FIELD).sendKeys(map.get("email"));
            findElement(CHECKBOX_NAME).click();
            findElement(CHECKBOX_AGE).click();
            findElement(CHECKBOX_TERMS).click();
            findElement(BUTTON_SUBMIT).click();
            return DriverManager.getDriver().getCurrentUrl();
        }
    }
