Feature:  To test Address Model

  Background:
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box

  @createPatient @smoke @all
  Scenario: Verify Address page for different country
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    Then User on Patient entry page verifies address model for given countries

  @createPatient @all
  Scenario: Verify Address page for different country
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters new patient info
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Edit patient info link
    Then User on Patient entry page verifies address model for given countries


  @createPatient @all
  Scenario: Create a patient and verify its values at edit screen for different countries
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters new patient info
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit patient info link
    Then User on Patient entry edit page verifies address values for given countries


  @createPatient @all
  Scenario: Create a patient and verify patient info get synced to server for different countries
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient entry page enters new patient info
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User verifies patient info get synced to server


