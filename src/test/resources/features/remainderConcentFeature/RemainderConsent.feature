Feature: to test  reminder- Consent toggle button

  @reminderConcent @smoke1 @all
  Scenario: create Patient and verify reminder-consent value in api service
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
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
    And User on Patient tab taps on sync link
    And User verifies reminder consent value in api service for enabled


  @reminderConcent @regression @all
  Scenario: create Patient,disable SMS reminder toggle and verify reminder-consent value in api service
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters new patient info by disabling consent reminder toggle
    And User on Diagnosis page select diagnosis
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User verifies reminder consent value in api service for disabled


