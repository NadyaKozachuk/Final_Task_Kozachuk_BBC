package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    private By newsButton = By.xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]");

    public void clickNewsButton() {

        driver.findElement(newsButton).click();
    }

    public void waitForPageLoadComplete(long timeout) {
        new WebDriverWait(driver, timeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }
}
