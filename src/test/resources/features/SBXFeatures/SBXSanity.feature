Feature: SBX sanity testcase

  @oldSBX
  Scenario Outline:End to end flow with to test update pop up functionality

    And New User registers on app
    And User search for facility as <facilityName>
    And User taps on Update pop up
    And User taps on Update button in play store
    And User taps on open button
    And Login as Server Admin
    And Server Admin allows access for user from backend
    And User run app in Background and relaunch it
    And User on patient tab taps on got it link
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
    Examples:
      | facilityName |
      | CHC Buccho   |


  @SBXsanity
  Scenario Outline: To test end to end Registration flow for SBX app
    And New User registers on app
    And User search for facility as <facilityName>
    And Login as Server Admin
    And Server Admin allows access for user from backend
    And User run app in Background and relaunch it
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    And User on Patient summary page enters new patient info
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    Then User on Patient summary page taps on Add new medicine button
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies updated medicine info
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    Examples:
      | facilityName |
      | CHC Buccho   |