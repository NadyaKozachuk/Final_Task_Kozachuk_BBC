package com.cucumber.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsPage extends BasePage {

    private static final By MAIN_NEWS_TITLE = By.xpath("//div[contains(@data-entityid,'container-top-stories#1')]//h3[contains(text(),'Trump')]");
    private static final By SECONDARY_NEWS_TITLES = By.xpath("//div[contains(@class,'secondary-item')]//h3");
    private static final By ARIA = By.xpath("//a[contains(@aria-label,'From Australia')]");
    private static final By SEARCH_FIELD = By.xpath("//input[@id='orb-search-q']");
    private static final By ARIA_NEWS_TITLE = By.xpath("//a[contains(@href,'https://www.bbc.co.uk/programmes/p06ypz3r')]");
    private static final By CORONAVIRUS_TAB = By.xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Coronavirus')]");
    private static final By YOUR_CORONAVIRUS_STORIES = By.xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Your Coronavirus Stories')]");


    public String getMainNewsTitle() {
        return findElement(MAIN_NEWS_TITLE).getText();
    }

    public String getAriaNewsTitle() {
        return findElement(ARIA_NEWS_TITLE).getText();
    }

    public String getAria() {
        return findElement(ARIA).getText();
    }

    public void clickCoronavirusTab() {
        findElement(CORONAVIRUS_TAB).click();
    }

    public void clickYourCoronavirusStoriesTab() {
        findElement(YOUR_CORONAVIRUS_STORIES).click();
    }

    public void inputAriaInSearchField() {
        findElement(SEARCH_FIELD).sendKeys(getAria(), Keys.ENTER);
    }

    public List<WebElement> getSecondaryNewsTitlesList() {
        return findElements(SECONDARY_NEWS_TITLES);
    }
}



