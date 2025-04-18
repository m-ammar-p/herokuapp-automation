@Regression
Feature: File Upload

  @severity=normal @smoke
  Scenario: Upload a file using Robot class
    Given The user is on the file upload page
    When the user uploads a file using the system dialog
    When the user uploads a file using Selenium
    Then the uploaded file name should be visible on the page

  @severity=normal @smoke
  Scenario: Upload a file using Send Keys
    Given The user is on the file upload page
    When the user uploads a file using Selenium
    Then the uploaded file name should be visible on the page
