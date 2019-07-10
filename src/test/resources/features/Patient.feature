Feature: Create Patient

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

  @createPatient @smoke
  Scenario: Create New Patient
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters new patient info
    And User on Diagnosis page taps on next Button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page taps on next ArrowButton
    And User on Patient summary page enters date
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    Then User on Patient tab verifies patient info present in recent patients list
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient with BP info

  @createPatient @smoke
  Scenario: Create New Patient Without phone number info
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters new patient info Without phone number
    And User on Diagnosis page taps on next Button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page taps on next ArrowButton
    And User on Patient summary page enters date
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    Then User on Patient tab verifies patient info present in recent patients list
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient with BP info

  @createPatient @smoke
  Scenario: Create New Patient Without blood Pressure info
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters new patient info
    And User on Diagnosis page taps on next Button
    And User on Patient summary page navigates back
    And User on Patient summary page taps on save Button
    And User on Patient tab taps on search text box
    Then User on search page searched for Registered Patient without BP info

  @createPatient @smoke
  Scenario: Create New Patient Without blood Pressure and Phone number info
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters new patient info Without phone number
    And User on Diagnosis page taps on next Button
    And User on Patient summary page navigates back
    And User on Patient summary page taps on save Button
    And User on Patient tab taps on search text box
    Then User on search page searched for Registered Patient without BP info


  @createPatient @smoke
  Scenario:User validate error message for invalid Data
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters invalid data for patients primary info
      | phoneNumber | 98789 |
    And User on Patient summary page verifies error message validation

  @createPatient @smoke
  Scenario: invalid Date
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters invalid date
      | Date | "31022019" |

