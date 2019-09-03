Feature: To Test "Add New" functionality for prescribed and customized Medicine.

  Background:
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list

  @medicine @smoke
  Scenario: Add new customized Medicine to already registered patient
    Then User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page taps on Add another medicine button
    And User on Patient summary page add new customized medicine
    And User on Patient summary page verifies custum drug list
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies updated medicine info

  @regression @medicine
  Scenario: User enter invalid data for customized medicine
    Then User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page taps on Add another medicine button
    And User on Patient summary page add new invalid customized medicine

   @medicine @smoke
  Scenario: Add new prescribed medicine to already registered patient
    Then User on Patient summary page taps on Add new medicine button
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies updated medicine info

   @medicine @smoke
  Scenario: get all medicine info for specific facility form api and validate it in UI
    And User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page validate medicine info at bp medicine page
