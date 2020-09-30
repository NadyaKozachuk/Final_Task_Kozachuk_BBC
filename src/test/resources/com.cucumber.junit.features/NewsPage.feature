
Feature: As user I want to find expected news titles on a News page

  Background:
    Given A user goes to BBC web site
    Then A user clicks on a News Tab
    And A user closes a Sign in PopUp

    Scenario: A headline news title contains the expected title
    Then A user should find expected headline news title "Trump and Biden duel in chaotic, bitter debate"


    Scenario: Secondary news titles contains the expected titles
    Then A user should find secondary news titles
    And The list of secondary news contains following expected titles
    | I Am Woman singer Helen Reddy dies aged 78 |
    | Patel considered asylum centre on Atlantic island |
    | Pandemic fills up Australian airline storage  |
    | India court delivers key mosque demolition ruling |


    Scenario: First article against specified Category has expected title

    And A user finds a headline's Category name
    Then A user enters a headline's Category name into a search field
    And A user finds a correct name of the first article "Ambulance Australia"