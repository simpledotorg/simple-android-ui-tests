Feature: miscellaneous feature -Patinet sync in different facility

  @smoke
  Scenario: Verify patient info sync in different facility
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility

  @smoke
  Scenario: Verify patient info sync in different facility -patient without bp
    Given User registers new user from api
    And User registers new patient without bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutBp

  @smoke
  Scenario: Verify patient info sync in different facility -patient with bp passport
    Given User registers new user from api
    And User registers new patient with bp passport from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withbpPassport

  @smoke
  Scenario: Verify patient info sync in different facility -patient without phonenumber and bp
    Given User registers new user from api
    And User registers new patient without phonenumber and bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutPhonenumberAndBp

  @smoke
  Scenario: Verify patient info sync in different facility-patient without phonenumber
    Given User registers new user from api
    And User registers new patient without phonenumber from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutPhonenumber

  @smoke
  Scenario Outline: App End to end flow to create verify patient info sync in different facility
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters new patient info
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User resets app
    And New User registers on app
    And User search for facility as <facilityName>
    Then User verifies Patient tab
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility

    Examples:
      | facilityName |
      | CHC Buccho   |


  @smoke
  Scenario: App End to end flow to create verify patient info sync in different facility
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters new patient info
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User resets app
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility


