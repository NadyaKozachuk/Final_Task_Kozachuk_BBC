package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NewsPage extends BasePage {
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    private By signInToNewsLaterButton = By.xpath("//button[contains(@class,'sign_in-exit')]");
    private By mainNewsTitle = By.xpath("//div[@data-entityid='container-top-stories#1']//h3");
    private By firstNewsTitle = By.xpath("//div[@data-entityid='container-top-stories#2']//h3");
    private By secondNewsTitle = By.xpath("//div[@data-entityid='container-top-stories#3']//h3");
    private By thirdNewsTitle = By.xpath("//div[@data-entityid='container-top-stories#4']//h3");
    private By aria = By.xpath("//div[contains(@class,'gs-c-promo-body gel-1/2')]//a[contains(@aria-label,'Australia')]");
    private By searchField = By.xpath("//input[@id='orb-search-q']");
    private By ariaNewsTitle = By.xpath("//a[contains(@href,'https://www.bbc.co.uk/programmes/p06ypz3r')]//span[contains(text(),'Ambulance')]");
    private By coronavirusButton = By.xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Coronavirus')]");

    public void clickSignInLaterPopup() {
        driver.findElement(signInToNewsLaterButton).click();
    }

    public void clickCoronavirusButton() {
        driver.findElement(coronavirusButton).click();
    }

    public By getSignInToNewsLaterButton() {
        return getSignInToNewsLaterButton();
    }

    public String getMainNewsTitle() {
        return driver.findElement(mainNewsTitle).getText();
    }

    public String getFirstNewsTitle() {
        return driver.findElement(firstNewsTitle).getText();
    }

    public String getSecondNewsTitle() {
        return driver.findElement(secondNewsTitle).getText();
    }

    public String getThirdNewsTitle() {
        return driver.findElement(thirdNewsTitle).getText();
    }

    public String getAria() {
        return driver.findElement(aria).getText();
    }

    public String getAriaNewsTitle() {
        return driver.findElement(ariaNewsTitle).getText();
    }

    public String[] getAllArticlesTittle() {
        String[] allArticlesTittle = new String[3];
        allArticlesTittle[0] = getFirstNewsTitle();
        allArticlesTittle[1] = getSecondNewsTitle();
        allArticlesTittle[2] = getThirdNewsTitle();
        return allArticlesTittle;
    }

    private void waitForLoading() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void inputAriaInSearchField() {
        driver.findElement(searchField).sendKeys(getAria(), Keys.ENTER);
    }

}

