Feature: miscellaneous feature -Patinet sync in different facility

  @smoke1 @patientsync @all
  Scenario: Verify patient info sync in different facility
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility

  @regression @patientsync @all
  Scenario: Verify patient info sync in different facility -patient without bp
    Given User registers new user from api
    And User registers new patient without bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutBp

  @regression @patientsync @all
  Scenario: Verify patient info sync in different facility -patient with bp passport
    Given User registers new user from api
    And User registers new patient with bp passport from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withbpPassport

  @regression @patientsync @all
  Scenario: Verify patient info sync in different facility -patient without phonenumber and bp
    Given User registers new user from api
    And User registers new patient without phonenumber and bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutPhonenumberAndBp

  @regression @patientsync @all
  Scenario: Verify patient info sync in different facility-patient without phonenumber
    Given User registers new user from api
    And User registers new patient without phonenumber from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutPhonenumber

  @regression @patientsync @all
  Scenario Outline: App End to end flow to create verify patient info sync in different facility- registration flow
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
    And User resets app
    And New User registers on app
    And User search for facility as <facilityName>
    Then User verifies Patient tab
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility

    Examples:
      | facilityName |
      | CHC Buccho   |


  @regression @patientsync @all
  Scenario: App End to end flow to create verify patient info sync in different facility
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
    And User resets app
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility

  @regression @patientsync @all
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


  @regression @patientsync @all1
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

  @regression @patientsync @all
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


   @patientsync @regression @all
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


  @patientsync @regression @all
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

  @patientsync1 @regression @all
  Scenario Outline: End to End flow ,set call result for Overdue patient as died and verify patient info sync in different facility
    Given User registers new user from api
    And User registers overdue patient
    And User LogsIn in app
    And User on Homepage taps on OVERDUE Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on remove from overdue list
    And User on Overdue tab selects <reasons>
    And User on Overdue reason page selects done button
    And User enters registered security pin
    And User on Homepage taps on PATIENTS Tab
    And User on Patient tab taps on sync link
    And User resets app
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on Search page verifies patient name should not be displayed
    Examples:
      | reasons |
      | Died    |

  @patientsync @regression @all
  Scenario: End to End flow ,add bp for Overdue patient and verify patient info sync in different facility
    Given User registers new user from api
    And User registers overdue patient
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
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
    And User on Search page selects patient form search list
    And User on Patient summary page verifies days information

