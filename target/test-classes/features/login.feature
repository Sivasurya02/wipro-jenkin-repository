@LoginTest
Feature: Login Functionality

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters valid username "tomsmith" and password "SuperSecretPassword!"
    And the user clicks on the login button
    Then the user should see a successful login message