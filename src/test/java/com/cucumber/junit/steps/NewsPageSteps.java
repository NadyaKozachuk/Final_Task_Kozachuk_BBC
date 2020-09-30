package com.cucumber.junit.steps;

import com.cucumber.junit.pages.HomePage;
import com.cucumber.junit.pages.NewsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class NewsPageSteps {
    HomePage homePage = new HomePage();
    NewsPage newsPage = new NewsPage();

    @Given("A user goes to BBC web site")
    public void goToBBC() {homePage.openBBCHomePage();
    }

    @Then("A user clicks on a News Tab")
    public void goToTheNewsPage() {
        homePage.clickNewsButton();
    }

    @And("A user closes a Sign in PopUp")
    public void closeSignInPopUp() {
        newsPage.clickSignInLaterPopup();
    }

    @Then("A user should find expected headline news title {string}")
    public void verifyHeadlineNewsTitle(String title) {
        AssertionsForClassTypes.assertThat(newsPage.getMainNewsTitle().equals(title))
                .overridingErrorMessage("The title is not correct.")
                .isTrue();
    }

    @Then("A user should find secondary news titles")
    public void secondaryNews() {
        Assertions.assertThat(newsPage.getSecondaryNewsTitlesList())
                .as("The secondary news titles list is not created");

    }

    @And("The list of secondary news contains following expected titles")
    public void secondaryNewsTitles(List<String> expectedSecondaryNewsTitles) {
        Assertions.assertThat(newsPage.getSecondaryNewsTitlesList())
                .extracting(WebElement::getText)
                .as("The secondary news titles are not as expected")
                .containsAll(expectedSecondaryNewsTitles);
    }

    @Then("A user finds a headline's Category name")
    public void getHeadlineCategoryTitle() {
        newsPage.getAria();
    }

    @Then("A user enters a headline's Category name into a search field")
    public void enterCategoryIntoSearchBar() {
        newsPage.inputAriaInSearchField();
    }

    @Then("A user finds a correct name of the first article {string}")
    public void actualFieldArticleName(String expectedFirstArticleTitle) {
        AssertionsForClassTypes.assertThat(newsPage.getAriaNewsTitle().equals(expectedFirstArticleTitle))
                .overridingErrorMessage("The title is not correct.")
                .isTrue();
    }
}

