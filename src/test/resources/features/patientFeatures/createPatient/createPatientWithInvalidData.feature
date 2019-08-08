Feature: to test create Patient functionality with invalid test data

  Background:
    Given User registers new user from api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box

  @invalid @smoke
  Scenario:User validate error message for invalid Data
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters invalid data for patients primary info
      | phoneNumber | 98789 |
    And User on Patient summary page verifies error message validation

  @invalid @smoke
  Scenario: invalid Date
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters invalid date
      | Date | "31022019" |


