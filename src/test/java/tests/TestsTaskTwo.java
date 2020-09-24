package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TestsTaskTwo extends BaseTest {

    private static final String EXPECTED_URL = "https://www.bbc.com/news/10725415";
    private static final String NO_STORY_ALERT_MESSAGE = "can't be blank";
    private static final String NO_NAME_ALERT_MESSAGE = "Name can't be blank";
    private static final String NO_CHECKBOX_AGE_ALERT_MESSAGE = "must be accepted";
    private static final String INVALID_EMAIL_ALERT_MESSAGE = "Email address is invalid";
    private static final String EMPTY_STORY = " ";
    private static final String INVALID_EMAIL = "ann@gmail_com";
    private static final String TEST_NO_NAME = " ";


    @Test
    public void checkThatPossibleToClickSendButtonAndStayOnGivenPage() {
        String actualURL = new HomePage(driver)
                .clickNewsButton()
                .waitForLoading()
                .clickSignInLaterPopup()
                .clickCoronavirusButton()
                .clickYourCoronavirusStoriesButton()
                .clickToHowToShare()
                .waitForLoading()
                .formWithEmptyStoryField(EMPTY_STORY);

        assertTrue(actualURL.contains(EXPECTED_URL));
    }

    @Test
    public void checkAlertMessageWhenStoryBlockIsEmpty() {
        String actualStoryAlert = new HomePage(driver)
                .clickNewsButton()
                .waitForLoading()
                .clickSignInLaterPopup()
                .clickCoronavirusButton()
                .clickYourCoronavirusStoriesButton()
                .clickToHowToShare()
                .waitForLoading()
                .formWithEmptyStoryField(EMPTY_STORY);

        assertEquals(actualStoryAlert, NO_STORY_ALERT_MESSAGE);
    }

    @Test
    public void checkAlertMessageWhenNameBlockIsEmpty() {
        String actualNameAlert = new HomePage(driver)
                .clickNewsButton()
                .waitForLoading()
                .clickSignInLaterPopup()
                .clickCoronavirusButton()
                .clickYourCoronavirusStoriesButton()
                .clickToHowToShare()
                .waitForLoading()
                .formWithEmptyNameField(TEST_NO_NAME);
        assertEquals(actualNameAlert, NO_NAME_ALERT_MESSAGE);
    }

    @Test
    public void checkAlertMessageWhenAgeCheckboxIsEmpty() {
        String actualAgeAlert = new HomePage(driver)
                .clickNewsButton()
                .waitForLoading()
                .clickSignInLaterPopup()
                .clickCoronavirusButton()
                .clickYourCoronavirusStoriesButton()
                .clickToHowToShare()
                .waitForLoading()
                .formFillWithEmptyAgeCheckbox();

        assertEquals(actualAgeAlert, NO_CHECKBOX_AGE_ALERT_MESSAGE);
    }

    @Test
    public void checkAlertMessageForInvalidEmail() {
        String actualEmailAlert = new HomePage(driver)
                .clickNewsButton()
                .waitForLoading()
                .clickSignInLaterPopup()
                .clickCoronavirusButton()
                .clickYourCoronavirusStoriesButton()
                .clickToHowToShare()
                .waitForLoading()
                .formFillWithInvalidEmail(INVALID_EMAIL);
        assertTrue(actualEmailAlert.contains(INVALID_EMAIL_ALERT_MESSAGE));
    }
}

