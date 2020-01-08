Feature: Create Patient with invalid test data

  Background:
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box

  @createPatient @smoke
  Scenario: User validate error message for invalid Data
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters invalid data for patients primary info
    And User on Patient summary page verifies error message for invalid data entry

  @createPatient @regression
  Scenario: invalid Date
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters invalid date
    And User on Patient summary page verifies error message for invalid date entry

  @createPatient @regression
  Scenario Outline: Create New Patient of age >=120
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters new patient info with age as <age>

    Examples:
      | age |
      | 125 |