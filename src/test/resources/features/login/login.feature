@Regression
Feature: Login functionality
  Background:
    Given The user is on the login page

  @severity=blocker @smoke
  Scenario: Verify user able to login
    Given I log in with tomsmith username
    Then  I check login is correct

  @severity=normal @smoke
  Scenario: Verify user able to logout
    Given I log in with tomsmith username
    Then  I check login is correct
    And I logout
    Then I check logout is correct

  @severity=normal @smoke
  Scenario Outline: Verify user not able to login
    Given I log in with <username> username
    Then  I check login is incorrect

    Examples:
      | username   |
      | !$#@$saeq  |
      | wqfswfs    |
      | %^@#$^$$#@ |