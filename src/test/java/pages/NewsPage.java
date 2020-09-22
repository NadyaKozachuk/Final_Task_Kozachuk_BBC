package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class NewsPage extends BasePage {
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class,'sign_in-exit')]")
    private WebElement signInToNewsLaterButton;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//h3")
    private WebElement mainNewsTitle;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#2']//h3")
    private WebElement firstNewsTitle;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#3']//h3")
    private WebElement secondNewsTitle;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#4']//h3")
    private WebElement thirdNewsTitle;

    @FindBy(xpath = "//div[contains(@class,'gs-c-promo-body gel-1/2')]//a[contains(@aria-label,'Australia')]")
    private WebElement aria;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchField;

    @FindBy(xpath = "//a[contains(@href,'https://www.bbc.co.uk/programmes/p06ypz3r')]//span[contains(text(),'Ambulance')]")
    private WebElement ariaNewsTitle;

    @FindBy(xpath = "//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Coronavirus')]")
    private WebElement coronavirusButton;

    public void clickSignInLaterPopup() {
        signInToNewsLaterButton.click();
    }

    public void clickCoronavirusButton() {
        coronavirusButton.click();
    }

    private void waitForLoading() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void inputAriaInSearchField() {
        searchField.sendKeys(getAria(), Keys.ENTER);
    }

    public String getMainNewsTitle() {
        return mainNewsTitle.getText();
    }

    public String getFirstNewsTitle() {
        return firstNewsTitle.getText();
    }

    public String getSecondNewsTitle() {
        return secondNewsTitle.getText();
    }

    public String getThirdNewsTitle() {
        return thirdNewsTitle.getText();
    }

    public String getAria() {
        return aria.getText();
    }

    public String getAriaNewsTitle() {
        return ariaNewsTitle.getText();
    }

    public String[] getAllArticlesTittle() {
        String[] allArticlesTittle = new String[3];
        allArticlesTittle[0] = getFirstNewsTitle();
        allArticlesTittle[1] = getSecondNewsTitle();
        allArticlesTittle[2] = getThirdNewsTitle();
        return allArticlesTittle;
    }
}

