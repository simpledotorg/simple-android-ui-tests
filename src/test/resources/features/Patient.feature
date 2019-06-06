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

  @createPatient @smoke
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

  @createPatient @smoke
  Scenario: Create New Patient Without phone number
    Then User searches for Patient name
    And User taps on registered patient
    And User enters new patient info Without phone number
    And User clicks on next Button at diagnosis screen
    And User enters new Bp Info
    And User taps on next ArrowButton
    And User enters date
    And User taps on save Button
    And User taps on appointment
    Then User verifies recent patients list

  @createPatient @smoke
  Scenario: Create New Patient Without blood Pressure
    Then User searches for Patient name
    And User taps on registered patient
    And User enters new patient info
    And User clicks on next Button at diagnosis screen
    And User navigates back
    And User taps on save Button
    Then User verifies recent patients list for patient without bp info
    Then User searched for Registered Patient without BP info

  @createPatient @smoke
  Scenario: Create New Patient Without blood Pressure and Phone number
    Then User searches for Patient name
    And User taps on registered patient
    And User enters new patient info Without phone number
    And User clicks on next Button at diagnosis screen
    And User navigates back
    And User taps on save Button
    Then User verifies recent patients list for patient without bp info
    Then User searched for Registered Patient without BP info


  @createPatient @smoke
  Scenario:User validate error message for invalid Data
    Then User searches for Patient name
    And User taps on registered patient
    And User enters invalid data for patients primary info
      | phoneNumber | 98789  |
    And User verifies error message validation

  @createPatient @smoke
  Scenario: invalid Date
    Then User searches for Patient name
    And User taps on registered patient
    And User enters invalid date
      | Date | "31022019" |

