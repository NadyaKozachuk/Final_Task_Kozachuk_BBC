Feature: As a user I want to verify that it's impossible to submit form with invalid data

  Background:
    When A user goes to BBC web site
    Then A user clicks on a News Tab
    And A user closes a Sign in PopUp
    Given A user clicks on a Coronavirus Tab
    Given A user clicks on a Your Coronavirus Stories Tab
    Given A user clicks on How to share with BBC News link

  Scenario: It's impossible to Submit form with empty Story field
    When A user fills the form with empty Story field
    And A user gets an Alert message "can't be blank"


  Scenario: It's impossible to Submit form with empty Name field
    When A user fills the form with empty Name field
    Then A user is still on the same page "https://www.bbc.com/news/10725415"

  Scenario: It's impossible to Submit form with invalid Email field
    When A user fills the form with invalid Email
    Then A user is still on the same page "https://www.bbc.com/news/10725415"

  Scenario: It's impossible to Submit form with empty Age checkbox
    When A user fills the form with empty Age checkbox
    Then A user is still on the same page "https://www.bbc.com/news/10725415"

  Scenario: It's impossible to Submit form with empty Terms checkbox
    When A user fills the form with empty Terms checkbox
    Then A user is still on the same page "https://www.bbc.com/news/10725415"