Feature: Search for Patient information by name

  @search  @regression
  Scenario: Search for patient without BP info
    Given User registers new user from api
    And User registers new patient without bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on search page searched for Registered Patient without BP info

  @search @smoke
  Scenario: Search for patient with BP info
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient

  @search @smoke  @cc
  Scenario Outline: verify alphabetical Patient log in search page
    Given User registers new user from api
    And User registers multiple patient <count> from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page verifies alphabetical patient logs
    Examples:
      | count |
      | 8     |