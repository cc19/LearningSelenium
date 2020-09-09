Feature: Test the login functionality on Guru99 bank website

  Scenario: The user should be able to login with correct username and password
    Given user is on the login page
    When user enters correct username and correct password
    Then user gets confirmation

    # Scenario Outline  is way of parameterization of scenarios, when scenario needs to be executed for multiple sets of data.
    # Scenario Outline must be followed by Examples, which specify the set of values for each parameter
   Scenario Outline: user should be able to login
     Given user is on the login page
     When user enters email <username>
     And user enters password <password>
     And user clicks submit button
     Then user gets confirmation

    Examples:
     | username | password |
     | mngr265692 | amApUbu |
#     | user | amApUbu |
#     | mngr265692 | pwd |
#     | himshim | jimjam |