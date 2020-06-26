Feature: Test the login functionality on Guru99 bank website
  Scenario: The user should be able to login with correct username and password
    Given user is on the login page
    When user enters correct username and correct password
    Then User gets confirmation