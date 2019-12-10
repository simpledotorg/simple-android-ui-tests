Feature: miscellaneous feature -Patinet sync in different facility

  @smoke @patientsync
  Scenario: Verify patient info sync in different facility
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility

  @regression @patientsync
  Scenario: Verify patient info sync in different facility -patient without bp
    Given User registers new user from api
    And User registers new patient without bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutBp

  @smoke @patientsync
  Scenario: Verify patient info sync in different facility -patient with bp passport
    Given User registers new user from api
    And User registers new patient with bp passport from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withbpPassport

  @regression @patientsync
  Scenario: Verify patient info sync in different facility -patient without phonenumber and bp
    Given User registers new user from api
    And User registers new patient without phonenumber and bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutPhonenumberAndBp

  @regression @patientsync
  Scenario: Verify patient info sync in different facility-patient without phonenumber
    Given User registers new user from api
    And User registers new patient without phonenumber from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutPhonenumber

  @smoke @patientsync
  Scenario Outline: App End to end flow to create verify patient info sync in different facility- registration flow
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


  @regression @patientsync
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

  @regression @patientsync
  Scenario: End to End flow for Edit Bp and verify patient info sync in different facility
    Given User registers new user from api
    And User registers a patient with multiple Bps
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit Bp Link
    And User on Patient summary page updates Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User resets app
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility
    And User on Search page selects patient form search list
    And User on Patient summary page verifies days information


  @regression @patientsync
  Scenario: End to End flow for Remove Bp and verify patient info sync in different facility
    Given User registers new user from api
    And User registers a patient with multiple Bps
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit Bp Link
    And User on Patient summary page taps on Remove Link
    And User on Patient summary page taps on remove button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User resets app
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility
    And User on Search page selects patient form search list
    And User on Patient summary page verifies list of bp info

  @regression @patientsync
  Scenario: End to End flow for Add prescribed medicine and verify patient info sync in different facility
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    Then User on Patient summary page taps on Add new medicine button
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies updated medicine info
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User resets app
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility
    And User on Search page selects patient form search list
    Then User on Patient summary page verifies updated medicine info


  @smoke @patientsync @regression
  Scenario Outline: End to End flow for Add prescribed medicine and verify patient info sync in different facility -registration flow
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    Then User on Patient summary page taps on Add new medicine button
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies updated medicine info
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User resets app
    And New User registers on app
    And User search for facility as <facilityName>
    Then User verifies Patient tab
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility
    And User on Search page selects patient form search list
    Then User on Patient summary page verifies updated medicine info
  Examples:
  | facilityName |
  | CHC Buccho   |


  @smoke @patientsync @regression
  Scenario: End to End flow for Add customize medicine and verify patient info sync in different facility
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    Then User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page taps on Add another medicine button
    And User on Patient summary page add new customized medicine
    And User on Patient summary page verifies custum drug list
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies updated medicine info
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User resets app
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility
    And User on Search page selects patient form search list
    Then User on Patient summary page verifies updated medicine info



