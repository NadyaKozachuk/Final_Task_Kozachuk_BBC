package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]")
    private WebElement newsButton;

    public HomePage clickNewsButton() {

        newsButton.click();
        return new HomePage(driver);
    }

    public NewsPage waitForLoading() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new NewsPage(driver);
    }
}
