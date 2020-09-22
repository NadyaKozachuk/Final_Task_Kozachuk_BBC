package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CoronavirusPage extends BasePage {
    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }

    private By yourCoronavirusStories = By.xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Your Coronavirus Stories')]");
    private By howToShare = By.xpath("//div[contains(@class,'nw-c-5-slice')]//h3[contains(text(),'How to share')]");

    public void clickYourCoronavirusStoriesButton() {
        driver.findElement(yourCoronavirusStories).click();
    }

    public void clickToHowToShare() {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(howToShare);
        builder.moveToElement(element).click().build().perform();
    }
}