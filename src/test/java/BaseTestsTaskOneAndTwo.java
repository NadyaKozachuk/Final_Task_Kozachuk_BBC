import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class BaseTestsTaskOneAndTwo {
    private WebDriver driver;

    @BeforeClass
    public void testsSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void profileSetUp() {
        driver.get("https://www.bbc.com");
    }

    private void waitForLoading() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkSetUp() {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.bbc.com");
    }

    @Test
    public void checkHeadlineArticleContainsSearchWord() {
        driver.findElement(xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]")).click();
        driver.findElement(xpath("//button[contains(@class,'sign_in-exit')] ")).click();
        waitForLoading();
        String mainNewsTitle =
                driver.findElement(xpath("//div[contains(@class,'gs-c-promo-body gs-u-display-none ')]//h3[contains(text(),'New fear grips Europe')]")).getText();

        assertEquals(mainNewsTitle, "New fear grips Europe as Covid tops 30m worldwide","Title changed or does not match");
    }

    @Test
    public void checkSecondaryArticleTitlesPresentOnThePage() {
        driver.findElement(xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]//a")).click();
        waitForLoading();
        ArrayList<String> titlesList = new ArrayList<String>();
        Collections.addAll(titlesList,
                "US to withdraw 2,200 troops from Iraq within weeks", "Oxford vaccine trial paused as participant falls ill", "Police shoot autistic boy after mum calls for help");
        for (String title : titlesList) {
            String xpathWithExpectedTitle = "//div[contains(@class,'gs-c-promo-body gel-1/2')]//h3[contains(text(),'" + title + "')]";
            xpathWithExpectedTitle = driver.findElement(xpath(xpathWithExpectedTitle)).getText();

            Assert.assertEquals(title, xpathWithExpectedTitle);
        }
    }

    @Test
    public void checkTheNameOfFirstArticleAgainstSpecifiedValue() {
        driver.findElement(xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]//a")).click();
        waitForLoading();
        driver.findElement(xpath("//button[contains(@class,'sign_in-exit')] ")).click();
        waitForLoading();
        String aria = driver.findElement(xpath("//div[contains(@class,'gs-c-promo-body gel-1/2')]//a[contains(@aria-label,'Middle East')]")).getText();
        waitForLoading();
        driver.findElement(xpath("//input[@id='orb-search-q']")).sendKeys(aria, Keys.ENTER);
        waitForLoading();
        String title =
                driver.findElement(xpath("//a[contains(@class,'css-vh7bxp-PromoLink ett16tt7')]//span[contains(text(),'Focus: ')]")).getText();

        Assert.assertEquals(title, "Focus: What's Behind the Wave of Middle East Protests?");
    }

    @Test
    public void checkThatPosiibleToClickSendButtonOnGivenPage() {
        driver.findElement(xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]//a")).click();
        waitForLoading();
        driver.findElement(xpath("//button[contains(@class,'sign_in-exit')] ")).click();
        driver.findElement(xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Coronavirus')]")).click();
        driver.findElement(xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Your Coronavirus Stories')]")).click();
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(xpath("//div[contains(@class,'nw-c-5-slice')]//h3[contains(text(),'How to share')]"));
        builder.moveToElement(element).click().build().perform();
        driver.findElement(xpath("//div[contains(@class,'input-threeup-leading')]//input[@placeholder='Name']")).sendKeys("Alice");
        driver.findElement(xpath("//div[@class=\"embed-content-container\"]//div[6]//input[@type='checkbox']")).click();
        driver.findElement(xpath("//div[@class=\"embed-content-container\"]//div[7]//input[@type='checkbox']")).click();
        driver.findElement(xpath("//button[@class=\"button\"]")).click();

        assertTrue(driver.getCurrentUrl().contains("10725415"));
    }

    @Test
    public void checkThatAlertMessageAppearsWhenStoryBlockIsEmpty() {
        driver.findElement(xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]//a")).click();
        waitForLoading();
        driver.findElement(xpath("//button[contains(@class,'sign_in-exit')] ")).click();
        driver.findElement(xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Coronavirus')]")).click();
        driver.findElement(xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Your Coronavirus Stories')]")).click();
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(xpath("//div[contains(@class,'nw-c-5-slice')]//h3[contains(text(),'How to share')]"));
        builder.moveToElement(element).click().build().perform();
        driver.findElement(xpath("//div[contains(@class,'input-threeup-leading')]//input[@placeholder='Name']")).sendKeys("Alice");
        driver.findElement(xpath("//div[@class=\"embed-content-container\"]//div[6]//input[@type='checkbox']")).click();
        driver.findElement(xpath("//div[@class=\"embed-content-container\"]//div[7]//input[@type='checkbox']")).click();
        driver.findElement(xpath("//button[@class=\"button\"]")).click();
        String alertMessageStoryBlock =
                driver.findElement(xpath("//div[contains(text(),'can')]")).getText();

        assertEquals(alertMessageStoryBlock, "can't be blank");
    }

    @Test
    public void checkThatAlertMessageAppearsWhenCheckBoxIsEmpty() {
        driver.findElement(xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]//a")).click();
        waitForLoading();
        driver.findElement(xpath("//button[contains(@class,'sign_in-exit')] ")).click();
        driver.findElement(xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Coronavirus')]")).click();
        driver.findElement(xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Your Coronavirus Stories')]")).click();
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(xpath("//div[contains(@class,'nw-c-5-slice')]//h3[contains(text(),'How to share')]"));
        builder.moveToElement(element).click().build().perform();
        driver.findElement(xpath("//div[contains(@class,'long-text-input-container')]//textarea")).sendKeys("My story...");
        driver.findElement(xpath("//div[contains(@class,'input-threeup-leading')]//input[@placeholder='Name']")).sendKeys("Alice");
        driver.findElement(xpath("//div[@class=\"embed-content-container\"]//div[6]//input[@type='checkbox']")).click();
        driver.findElement(xpath("//button[@class=\"button\"]")).click();
        String alertMessageStoryBlock =
                driver.findElement(xpath("//div[contains(@class,'input-error-message')]")).getText();

        assertEquals(alertMessageStoryBlock, "must be accepted");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
