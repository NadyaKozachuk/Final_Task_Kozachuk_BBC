package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage {
    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Your Coronavirus Stories')]")
    private WebElement yourCoronavirusStories;

    @FindBy(xpath = "//div[contains(@class,'nw-c-5-slice')]//h3[contains(text(),'How to share')]")
    private WebElement howToShare;

    public void clickYourCoronavirusStoriesButton() {
        yourCoronavirusStories.click();
    }

    public void clickToHowToShare() {
        Actions builder = new Actions(driver);
        WebElement element = howToShare;
        builder.moveToElement(element).click().build().perform();
    }
}