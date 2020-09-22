package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class YourStoryPage extends BasePage {
    public YourStoryPage(WebDriver driver) {
        super(driver);
    }

    private static final String NAME = "Alice";
    private static final String INVALID_EMAIL = "Ann@gmail_com";

    private By nameField = By.xpath("//div[contains(@class,'input-threeup-leading')]//input[@placeholder='Name']");
    private By ageCheckbox = By.xpath("//div[@class=\"embed-content-container\"]//div[6]//input[@type='checkbox']");
    private By termsOfServiceCheckbox = By.xpath("//div[@class=\"embed-content-container\"]//div[7]//input[@type='checkbox']");
    private By submitButton = By.xpath("//button[@class='button']");
    private By storyAlertMessage = By.xpath("//div[contains(text(),'can')]");
    private By nameAlertMessage = By.xpath("//div[contains(text(),'Name')]");
    private By ageAlertMessage = By.xpath("//div[@class=\"embed-content-container\"]//div[6]//div[contains(text(),'must be accepted')]");
    private By invalidEmailMessage = By.xpath("//div[contains(text(),'Email address is invalid')]");
    private By emailField = By.xpath("//input[@placeholder='Email address']");

    public String getStoryAlertMessage() {
        return driver.findElement(storyAlertMessage).getText();
    }

    public String getNameAlertMessage() {
        return driver.findElement(nameAlertMessage).getText();
    }

    public String getAgeAlertMessage() {
        return driver.findElement(ageAlertMessage).getText();
    }

    public String getInvalidEmailMessage() {
        return driver.findElement(invalidEmailMessage).getText();
    }

    public void inputNameInField() {
        driver.findElement(nameField).sendKeys(NAME, Keys.ENTER);
    }

    public void inputInvalidEmail() {
        driver.findElement(emailField).sendKeys(INVALID_EMAIL, Keys.ENTER);
    }

    public void clickCheckboxAge() {
        driver.findElement(ageCheckbox).click();
    }

    public void clickCheckboxTermsOfService() {
        driver.findElement(termsOfServiceCheckbox).click();
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}
