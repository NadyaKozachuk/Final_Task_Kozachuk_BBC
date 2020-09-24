package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    @FindBy(xpath = "//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Your Coronavirus Stories')]")
    private WebElement yourCoronavirusStories;

    public CoronavirusPage clickYourCoronavirusStoriesButton() {
        yourCoronavirusStories.click();
        return new CoronavirusPage(driver);

    }

    public NewsPage clickSignInLaterPopup() {
        signInToNewsLaterButton.click();
        return this;
    }

    public NewsPage clickCoronavirusButton() {
        coronavirusButton.click();
        return this;
    }

    public NewsPage inputAriaInSearchField() {
        searchField.sendKeys(getAria(), Keys.ENTER);
        return new NewsPage(driver);
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

    public String[] getAllSecondaryArticlesTittle() {
        String[] allSecondaryArticlesTittle = new String[3];
        allSecondaryArticlesTittle[0] = getFirstNewsTitle();
        allSecondaryArticlesTittle[1] = getSecondNewsTitle();
        allSecondaryArticlesTittle[2] = getThirdNewsTitle();
        return allSecondaryArticlesTittle;
    }
}

