Feature: Create Patient

  Background:
    Given User Registers New User through API
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button

  @createPatient
  Scenario: Create New Patient
    Then User searches for Patient name
    And User taps on registered patient
    And User enters new patient info
    And User clicks on next Button at diagnosis screen
    And User enters new Bp Info
    And User taps on next ArrowButton
    And User enters date
    And User taps on save Button
    And User taps on appointment
    Then User verifies recent patients list

