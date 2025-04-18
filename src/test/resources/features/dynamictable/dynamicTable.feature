@Regression
Feature: Dynamic Table Data Handling

  Background:
    Given  The user is on the dynamic table page

  Scenario: Extract and print all user full names from the table
    When I extract all full names from the first table
    Then I print the full names in the console

  Scenario: Verify a specific company exists in the table
    Then the first table should contain the full name "Jason Doe"

  Scenario: Extract and print any column's data
    When I extract data from column 3 of the first table
    Then I print the column values in the console
