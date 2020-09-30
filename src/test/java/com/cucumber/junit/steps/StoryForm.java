package com.cucumber.junit.steps;

import com.cucumber.junit.pages.CoronavirusPage;
import com.cucumber.junit.pages.FormToFill;
import com.cucumber.junit.pages.HomePage;
import com.cucumber.junit.pages.NewsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;

import static org.testng.AssertJUnit.assertEquals;

public class StoryForm {
    NewsPage newsPage = new NewsPage();

    CoronavirusPage coronavirusPage = new CoronavirusPage();
    FormToFill formToFill = new FormToFill();

    @Given("A user clicks on a Coronavirus Tab")
    public void clickCoronavirusTab() {
        newsPage.clickCoronavirusTab();
    }

    @Given("A user clicks on a Your Coronavirus Stories Tab")
    public void clickYourCoronavirusStory() {
        newsPage.clickYourCoronavirusStoriesTab();
    }

    @Given("A user clicks on How to share with BBC News link")
    public void clickShareWithBBC() {
        coronavirusPage.clickToHowToShare();
    }

    @When("A user fills the form with empty Story field")
    public void fillFormWithEmptyStoryField() {
        formToFill.formWithEmptyStoryField();
    }

    @When("A user fills the form with empty Name field")
    public void fillFormWithEmptyNameField() {
        formToFill.formWithEmptyNameField();
    }

    @When("A user fills the form with invalid Email")
    public void fillFormWithInvalidEmail() {
    formToFill.formWithInvalidEmail();
    }

    @When("A user fills the form with empty Age checkbox")
    public void fillFormWithUncheckedIAmOver16() {
        formToFill.formWithEmptyAgeCheckbox();
    }

    @When("A user fills the form with empty Terms checkbox")
    public void fillFormWithUncheckedAcceptTerms() {
        formToFill.formWithEmptyTermsCheckbox();
    }

    @Then("A user is still on the same page {string}")
    public void expectedURL(String title) {
        AssertionsForClassTypes.assertThat(formToFill.verifyURL().equals(title))
                .overridingErrorMessage("URL is not as expected.")
                .isTrue();
    }
}
