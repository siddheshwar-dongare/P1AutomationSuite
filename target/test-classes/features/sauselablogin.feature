@LogIn
Feature: log in functionality

    Scenario: user logged in successfully
        Given user is on sauselab log in page
        When user enter "standard_user" and "secret_sauce" in fields
        And user click on log in button
        Then user is logged in successfully