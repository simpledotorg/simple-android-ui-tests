Feature: Miscellaneous feature

  @overdue @smoke
  Scenario: Verify patient info for whose appointment is scheduled for today
    Given User registers new user from api
    Given User creates overdue patient with appointment as of today
    And User LogsIn in app
    And User on Homepage taps on Overdue Tab
    Then User on Overdue tab verifies patient info is not present in list
    And User on Homepage taps on Patients Tab
    And User on Patient tab taps on sync link

  @custom_drug
  Scenario: create drug from api and validate it in UI
    Given User registers new user from api
    And User registers new patient with bp from api
    And User create protocol drug from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    Then User on patient summary detail page verifies medicine info
    And User on Patient summary page taps on Update Medicine info
    Then User on Patient summary page verifies custum drug list

  @miscellaneous @smoke
  Scenario: Registering user form api and denied it's access from backend then login as user and verify app UI .
    Given User registers new user from api
    And Login as Server Admin
    And Server Admin selects Facilities option from manage overlay
    And Server Admins selects facility name CHC Bagta
    And Server Admin denies user access from backend
    And User LogsIn in app
    Then User on patient tab verifies sync link should not be present


  @miscellaneous1 @regression
  Scenario: Login as user then perform search ,denied it's access from backend then verify app UI for sync indicator .
    Given User registers new user from api
    And User registers a patient with multiple Bps
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on Search page searched for Registered Patient
    And Login as Server Admin
    And Server Admin selects Facilities option from manage overlay
    And Server Admins selects facility name CHC Bagta
    And Server Admin denies user access from backend
    And User navigates back
    And User taps on back button
    Then User on patient tab verifies sync link should not be present


  @miscellaneous @regression
  Scenario:Registering user form api and denied it's access from backend then verify sync pending message
    Given User registers new user from api
    And User registers a patient with multiple Bps
    And User LogsIn in app
    And Login as Server Admin
    And Server Admin selects Facilities option from manage overlay
    And Server Admins selects facility name CHC Bagta
    And Server Admin denies user access from backend
    And User on Patient tab taps on sync link
    Then User on patient tab verifies sync error message
    And User on Patient tab taps on okay button
    Then User on patient tab verifies sync pending status should be present

  @miscellaneous1 @regression
  Scenario:Log in as user and get its access denied from backend,add new patient data from app,allow access from backend
  then verify patient data should get synced in server.
    Given User registers new user from api
    And Login as Server Admin
    And Server Admin selects Facilities option from manage overlay
    And Server Admins selects facility name CHC Bagta
    And Server Admin denies user access from backend
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
    Then Server Admin allows access for user from backend
    And User run app in Background and relaunch it
    And User enters registered security pin
    And User on Patient tab taps on sync link
    Then User on Patient tab verify patient data got synced in server


  @miscellaneous @smoke
  Scenario Outline: Register user from app ,get it's access denied from backend and then verify app ui for sync indicator.
    And New User registers on app
    And User search for facility as <facilityName>
    And User verifies homepage
    Then User verifies Patient tab
    And Login as Server Admin
    And Server Admin selects Facilities option from manage overlay
    And Server Admins selects facility name CHC Bagta
    And Server Admin denies user access from backend
    And User on Patient tab taps on sync link
    Then User on patient tab verifies sync error message

    Examples:
      | facilityName |
      | CHC Bagta    |

