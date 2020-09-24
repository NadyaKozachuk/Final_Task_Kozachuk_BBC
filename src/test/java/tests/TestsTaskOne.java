package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class TestsTaskOne extends BaseTest {
    private static final String EXPECTED_MAIN_NEWS_TITLE = "UK sets £10,000 fines for self-isolation breaches";
    private static final String EXPECTED_FIRST_NEWS_TITLE = "Trump says Supreme Court nominee will be a woman";
    private static final String EXPECTED_SECOND_NEWS_TITLE = "Australia virus cases 'set to be lowest in months'";
    private static final String EXPECTED_THIRD_NEWS_TITLE = "Judge blocks US attempts to ban China's WeChat";
    private static final String EXPECTED_ARIA_NEWS_TITLE = "Ambulance Australia";

    @Test
    public void checkHeadlineArticleContainsExpectedTitle() {
        String actualMainNewsTitle = new HomePage(driver)
                .clickNewsButton()
                .waitForLoading()
                .clickSignInLaterPopup()
                .getMainNewsTitle();

        assertEquals(actualMainNewsTitle, EXPECTED_MAIN_NEWS_TITLE);
    }

    @Test
    public void checkSecondaryArticleTitlesPresentOnThePage() {
        String[] allExpectedArticlesTittle = new String[3];
        allExpectedArticlesTittle[0] = EXPECTED_FIRST_NEWS_TITLE;
        allExpectedArticlesTittle[1] = EXPECTED_SECOND_NEWS_TITLE;
        allExpectedArticlesTittle[2] = EXPECTED_THIRD_NEWS_TITLE;
        String[] actualSecondaryNewsTitles = new HomePage(driver)
                .clickNewsButton()
                .waitForLoading()
                .clickSignInLaterPopup()
                .getAllSecondaryArticlesTittle();

        assertEquals(actualSecondaryNewsTitles, allExpectedArticlesTittle);
    }

    @Test
    public void checkTheTitleOfFirstArticleAgainstSpecifiedAria() {
        String actualNewsTitle = new HomePage(driver)
                .clickNewsButton()
                .waitForLoading()
                .clickSignInLaterPopup()
                .getAriaNewsTitle();

        assertEquals(actualNewsTitle, EXPECTED_ARIA_NEWS_TITLE);
    }
}
