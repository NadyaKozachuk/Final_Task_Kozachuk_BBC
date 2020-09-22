package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestsTaskOne extends BaseTest {
    private static final String EXPECTED_MAIN_NEWS_TITLE = "UK sets £10,000 fines for self-isolation breaches";
    private static final String EXPECTED_FIRST_NEWS_TITLE = "Trump says Supreme Court nominee will be a woman";
    private static final String EXPECTED_SECOND_NEWS_TITLE = "Australia virus cases 'set to be lowest in months'";
    private static final String EXPECTED_THIRD_NEWS_TITLE = "Judge blocks US attempts to ban China's WeChat";
    private static final String EXPECTED_ARIA_NEWS_TITLE = "Ambulance Australia";

    @Test
    public void checkHeadlineArticleContainsExpectedTitle() {
        getHomePage().clickNewsButton();
        waitForLoading();
        getNewsPage().clickSignInLaterPopup();
        getNewsPage().getMainNewsTitle();
        assertEquals(getNewsPage().getMainNewsTitle(), EXPECTED_MAIN_NEWS_TITLE);
    }

    @Test
    public void checkSecondaryArticleTitlesPresentOnThePage() {
        getHomePage().clickNewsButton();
        waitForLoading();
        getNewsPage().clickSignInLaterPopup();
        getNewsPage().getAllArticlesTittle();
        String[] allExpectedArticlesTittle = new String[3];
        allExpectedArticlesTittle[0] = EXPECTED_FIRST_NEWS_TITLE;
        allExpectedArticlesTittle[1] = EXPECTED_SECOND_NEWS_TITLE;
        allExpectedArticlesTittle[2] = EXPECTED_THIRD_NEWS_TITLE;
        Assert.assertEquals(allExpectedArticlesTittle, getNewsPage().getAllArticlesTittle());
    }

    @Test
    public void checkTheTitleOfFirstArticleAgainstSpecifiedAria() {
        getHomePage().clickNewsButton();
        waitForLoading();
        getNewsPage().clickSignInLaterPopup();
        getNewsPage().getAria();
        getNewsPage().inputAriaInSearchField();
        Assert.assertEquals(getNewsPage().getAriaNewsTitle(), EXPECTED_ARIA_NEWS_TITLE);
    }
}
