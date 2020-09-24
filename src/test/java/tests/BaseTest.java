package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CoronavirusPage;
import pages.FormToFill;
import pages.HomePage;
import pages.NewsPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    private static final String BBC_URL = "https://www.bbc.com";

    @BeforeClass
    public void testsSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void profileSetUp() {
        driver.get(BBC_URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void waitForLoading() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public NewsPage getNewsPage() {
        return new NewsPage(getDriver());
    }

    public CoronavirusPage getCoronavirusPage() {
        return new CoronavirusPage(getDriver());
    }


    public FormToFill getFormToFill() {
        return new FormToFill(getDriver());
    }
}



