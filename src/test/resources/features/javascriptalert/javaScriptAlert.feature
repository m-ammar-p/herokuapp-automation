@Regression
Feature: javascript Alert Handling

  Background:
    Given The user is on the javaScript alerts page

  Scenario: Handle JS Alert
    When I click the JS Alert button
    Then I should see alert message "I am a JS Alert"
    And I accept the alert
    Then the result message should be "You successfully clicked an alert"

  Scenario: Handle JS Confirm
    When I click the JS Confirm button
    Then I should see alert message "I am a JS Confirm"
    And I dismiss the alert
    Then the result message should be "You clicked: Cancel"

  Scenario: Handle JS Prompt
    When I click the JS Prompt button
    Then I should see alert message "I am a JS prompt"
    And I enter "Hello World" in the alert and accept
    Then the result message should be "You entered: Hello World"