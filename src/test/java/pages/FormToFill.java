package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FormToFill extends BasePage {

    public FormToFill(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@placeholder='Tell us your story. ']")
    private WebElement fieldYourStory;

    @FindBy(xpath = "//div[contains(@class,'input-threeup-leading')]//input[@placeholder='Name']")
    private WebElement fieldYourName;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement fieldYourEmail;

    @FindBy(xpath = "//input[@placeholder='Contact number ']")
    private WebElement fieldYourNumber;

    @FindBy(xpath = "//input[@placeholder='Location ']")
    private WebElement fieldYourLocation;

    @FindBy(xpath = "//div[@class='checkbox'][1]//input")
    private WebElement checkboxName;

    @FindBy(xpath = "//div[@class='checkbox'][2]//input")
    private WebElement checkboxAge;

    @FindBy(xpath = "//div[@class='checkbox'][3]//input")
    private WebElement checkboxTerms;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[contains(text(),'can')]")
    private WebElement storyAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Name')]")
    private WebElement nameAlertMessage;

    @FindBy(xpath = "//div[@class=\"embed-content-container\"]//div[6]//div[contains(text(),'must be accepted')]")
    private WebElement ageAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Email address is invalid')]")
    private WebElement invalidEmailMessage;


    public FormToFill waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public String formWithEmptyStoryField(String testText) {
        fieldYourStory.sendKeys(testText);
        fieldYourName.sendKeys("testName");
        fieldYourEmail.sendKeys("testEmail");
        fieldYourNumber.sendKeys("testPhoneNumber");
        fieldYourLocation.sendKeys("testLocation");
        checkboxName.click();
        checkboxAge.click();
        checkboxTerms.click();
        buttonSubmit.click();
        return storyAlertMessage.getText();
    }

    public String formWithEmptyNameField(String testName) {
        fieldYourStory.sendKeys("testStory");
        fieldYourName.sendKeys(testName);
        fieldYourEmail.sendKeys("testEmail");
        fieldYourNumber.sendKeys("testPhoneNumber");
        fieldYourLocation.sendKeys("testLocation");
        checkboxName.click();
        checkboxAge.click();
        checkboxTerms.click();
        buttonSubmit.click();
        return nameAlertMessage.getText();
    }

    public String formFillWithEmptyAgeCheckbox() {
        fieldYourStory.sendKeys("testStory");
        fieldYourName.sendKeys("testName");
        fieldYourEmail.sendKeys("testEmail");
        fieldYourNumber.sendKeys("testPhoneNumber");
        fieldYourLocation.sendKeys("testLocation");
        checkboxName.click();
        checkboxTerms.click();
        buttonSubmit.click();
        return ageAlertMessage.getText();
    }

    public String formFillWithInvalidEmail(String dataForEmail) {
        fieldYourStory.sendKeys("testStory");
        fieldYourName.sendKeys("testName");
        fieldYourEmail.sendKeys(dataForEmail);
        fieldYourNumber.sendKeys("testPhoneNumber");
        fieldYourLocation.sendKeys("testLocation");
        checkboxName.click();
        checkboxAge.click();
        checkboxTerms.click();
        buttonSubmit.click();
        return invalidEmailMessage.getText();
    }
}


