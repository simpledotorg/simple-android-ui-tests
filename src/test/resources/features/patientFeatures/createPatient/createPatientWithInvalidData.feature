Feature: Create Patient with invalid test data

  Background:
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box

  @createPatient @smoke1  @all
  Scenario: User validate error message for invalid Data
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters invalid data for patients primary info
    And User on Patient summary page verifies error message for invalid data entry

  @createPatient @regression  @all
  Scenario Outline: verify age validation for age >=120 or age=0
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters new patient info with age as <age>
    And User on Patient summary page verifies error message for invalid age
    Examples:
      | age |
      | 125 |
      | 0   |