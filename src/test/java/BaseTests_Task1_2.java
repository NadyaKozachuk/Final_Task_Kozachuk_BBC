import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class BaseTests_Task1_2 {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com");
    }

    @Test
    public void checkSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver"); // set up path to the chromedriver
        WebDriver chromeDriver = new ChromeDriver(); // Creates a new Chrome instance
        chromeDriver.get("https://www.bbc.com"); // Navigates to a page by address
    }
    @Test
    public void checkHeadlineArticleContainsSearchWord() {
        driver.findElement(xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]")).click();
        driver.findElement(xpath("//button[contains(@class,'sign_in-exit')] ")).click();
        String mainNewsTitle =
                driver.findElement(xpath("//div[contains(@class,'gs-c-promo-body gs-u-display-none gs-u-display-')]//h3[contains(text(),'Fire destroys')]")).getText();
        assertEquals(mainNewsTitle, "Fire destroys Greece's largest migrant camp");
    }

    @Test
    public void checkSecondaryrAticleTitlesPresentOnThePage() {
        driver.findElement(xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]//a")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ArrayList<String> titlesList = new ArrayList<String>();
        Collections.addAll(titlesList,
                "US to withdraw 2,200 troops from Iraq within weeks", "Oxford vaccine trial paused as participant falls ill", "Police shoot autistic boy after mum calls for help");
        for (String title : titlesList) {
            String xpathWithExpectedTitle = "//div[contains(@class,'gs-c-promo-body gel-1/2')]//h3[contains(text(),'" + title + "')]";
            xpathWithExpectedTitle = driver.findElement(xpath(xpathWithExpectedTitle)).getText();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Assert.assertEquals(title, xpathWithExpectedTitle);
        }
    }

    @Test
    public void checkTheNameOfFirstArticleAgainstSpecifiedValue() {
        driver.findElement(xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]//a")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(xpath("//button[contains(@class,'sign_in-exit')] ")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String aria = driver.findElement(xpath("//div[contains(@class,'gs-c-promo-body gel-1/2')]//a[contains(@aria-label,'Middle East')]")).getText();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(xpath("//input[@id='orb-search-q']")).sendKeys(aria, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String title =
                driver.findElement(xpath("//a[contains(@class,'css-vh7bxp-PromoLink ett16tt7')]//span[contains(text(),'Focus: ')]")).getText();
        Assert.assertEquals(title, "Focus: What's Behind the Wave of Middle East Protests?");
    }

    @Test
    public void checkThatPosiibleToClickSendButtonOnGivenPage() {
        driver.findElement(xpath("//div[contains(@id,'orb-nav-links')]//li[contains(@class,'orb-nav-newsdotcom')]//a")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(xpath("//button[contains(@class,'sign_in-exit')] ")).click();
        driver.findElement(xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Coronavirus')]")).click();
        WebElement pageLoading = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Your Coronavirus Stories')]")));
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(xpath("//button[contains(@class,'sign_in-exit')] ")).click();
        driver.findElement(xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Coronavirus')]")).click();
        WebElement pageLoading = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Your Coronavirus Stories')]")));
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(xpath("//button[contains(@class,'sign_in-exit')] ")).click();
        driver.findElement(xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Coronavirus')]")).click();
        WebElement pageLoading = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[contains(@class,'nw-c-nav__wide')]//span[contains(text(),'Your Coronavirus Stories')]")));
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

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
