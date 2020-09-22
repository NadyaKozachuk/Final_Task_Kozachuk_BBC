package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TestsTaskTwo extends BaseTest {

    private static final String EXPECTED_URL = "https://www.bbc.com/news/10725415";
    private static final String STORY_ALERT_MESSAGE = "can't be blank";
    private static final String NAME_ALERT_MESSAGE = "Name can't be blank";
    private static final String CHECKBOX_AGE_ALERT_MESSAGE = "must be accepted";
    private static final String INVALID_EMAIL_ALERT_MESSAGE = "Email address is invalid";

    @Test
    public void checkThatPossibleToClickSendButtonOnGivenPage() {
        getHomePage().clickNewsButton();
        waitForLoading();
        getNewsPage().clickSignInLaterPopup();
        getNewsPage().clickCoronavirusButton();
        getCoronavirusPage().clickYourCoronavirusStoriesButton();
        waitForLoading();
        getCoronavirusPage().clickToHowToShare();
        waitForLoading();
        getYourStoryPage().inputNameInField();
        getYourStoryPage().clickCheckboxAge();
        getYourStoryPage().clickCheckboxTermsOfService();
        getYourStoryPage().clickSubmitButton();
        assertTrue(driver.getCurrentUrl().contains(EXPECTED_URL));
    }

    @Test
    public void checkAlertMessageWhenStoryBlockIsEmpty() {
        getHomePage().clickNewsButton();
        waitForLoading();
        getNewsPage().clickSignInLaterPopup();
        getNewsPage().clickCoronavirusButton();
        getCoronavirusPage().clickYourCoronavirusStoriesButton();
        waitForLoading();
        getCoronavirusPage().clickToHowToShare();
        waitForLoading();
        getYourStoryPage().clickSubmitButton();
        assertEquals(getYourStoryPage().getStoryAlertMessage(), STORY_ALERT_MESSAGE);
    }

    @Test
    public void checkAlertMessageWhenNameBlockIsEmpty() {
        getHomePage().clickNewsButton();
        waitForLoading();
        getNewsPage().clickSignInLaterPopup();
        getNewsPage().clickCoronavirusButton();
        getCoronavirusPage().clickYourCoronavirusStoriesButton();
        waitForLoading();
        getCoronavirusPage().clickToHowToShare();
        waitForLoading();
        getYourStoryPage().clickSubmitButton();
        assertEquals(getYourStoryPage().getNameAlertMessage(), NAME_ALERT_MESSAGE);
    }

    @Test
    public void checkAlertMessageWhenAgeCheckboxIsEmpty() {
        getHomePage().clickNewsButton();
        waitForLoading();
        getNewsPage().clickSignInLaterPopup();
        getNewsPage().clickCoronavirusButton();
        getCoronavirusPage().clickYourCoronavirusStoriesButton();
        waitForLoading();
        getCoronavirusPage().clickToHowToShare();
        waitForLoading();
        getYourStoryPage().clickSubmitButton();
        assertEquals(getYourStoryPage().getAgeAlertMessage(), CHECKBOX_AGE_ALERT_MESSAGE);
    }

    @Test
    public void checkAlertMessageInvalidEmail() {
        getHomePage().clickNewsButton();
        waitForLoading();
        getNewsPage().clickSignInLaterPopup();
        getNewsPage().clickCoronavirusButton();
        getCoronavirusPage().clickYourCoronavirusStoriesButton();
        waitForLoading();
        getCoronavirusPage().clickToHowToShare();
        waitForLoading();
        getYourStoryPage().inputInvalidEmail();
        getYourStoryPage().clickSubmitButton();
        assertTrue(getYourStoryPage().getInvalidEmailMessage().contains(INVALID_EMAIL_ALERT_MESSAGE));
    }

}

