Feature: Create Patient

  Background:
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box

  @createPatient @smoke @all
  Scenario: Create New Patient
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters new patient info
    And User on Diagnosis page select diagnosis
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient

  @createPatient @regression @all
  Scenario: Create New Patient Without phone number info
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters new patient info Without phone number
    And User on Diagnosis page select diagnosis
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient

  @createPatient @regression @all
  Scenario: Create New Patient Without blood Pressure info
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters new patient info
    And User on Diagnosis page select diagnosis
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page navigates back
    And User on Patient summary page taps on save Button
    And User on Patient tab taps on search text box
    Then User on search page searched for Registered Patient without BP info

  @createPatient @regression @all
  Scenario: Create New Patient Without blood Pressure and Phone number info
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters new patient info Without phone number
    And User on Diagnosis page select diagnosis
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page navigates back
    And User on Patient summary page taps on save Button
    And User on Patient tab taps on search text box
    Then User on search page searched for Registered Patient without BP info


  @createPatient @all
  Scenario Outline: Create New Patient of age 120
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters new patient info with age as <age>
    And User on Diagnosis page select diagnosis
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    Examples:
      | age |
      | 120 |


