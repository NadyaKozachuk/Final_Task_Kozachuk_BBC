package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourStoryPage extends BasePage {
    public YourStoryPage(WebDriver driver) {
        super(driver);
    }

    private static final String NAME = "Alice";
    private static final String INVALID_EMAIL = "Ann@gmail_com";

    @FindBy(xpath = "//div[contains(@class,'input-threeup-leading')]//input[@placeholder='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//div[@class=\"embed-content-container\"]//div[6]//input[@type='checkbox']")
    private WebElement ageCheckbox;

    @FindBy(xpath = "//div[@class=\"embed-content-container\"]//div[7]//input[@type='checkbox']")
    private WebElement termsOfServiceCheckbox;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(),'can')]")
    private WebElement storyAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Name')]")
    private WebElement nameAlertMessage;

    @FindBy(xpath = "//div[@class=\"embed-content-container\"]//div[6]//div[contains(text(),'must be accepted')]")
    private WebElement ageAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Email address is invalid')]")
    private WebElement invalidEmailMessage;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement emailField;

    public String getStoryAlertMessage() {
        return storyAlertMessage.getText();
    }

    public String getNameAlertMessage() {
        return nameAlertMessage.getText();
    }

    public String getAgeAlertMessage() {
        return ageAlertMessage.getText();
    }

    public String getInvalidEmailMessage() {
        return invalidEmailMessage.getText();
    }

    public void inputNameInField() {
        nameField.sendKeys(NAME, Keys.ENTER);
    }

    public void inputInvalidEmail() {
        emailField.sendKeys(INVALID_EMAIL, Keys.ENTER);
    }

    public void clickCheckboxAge() {
        ageCheckbox.click();
    }

    public void clickCheckboxTermsOfService() {
        termsOfServiceCheckbox.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
