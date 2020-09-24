package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class CoronavirusPage extends BasePage {
    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'nw-c-5-slice')]//h3[contains(text(),'How to share')]")
    private WebElement howToShare;

    public FormToFill waitForLoading() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new FormToFill (driver);
    }



    public CoronavirusPage clickToHowToShare() {
        Actions builder = new Actions(driver);
        WebElement element = howToShare;
        builder.moveToElement(element).click().build().perform();
        return this;
    }


}
