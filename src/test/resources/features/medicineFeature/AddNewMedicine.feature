Feature: To Test "Add New" functionality for prescribed and customized Medicine.

  Background:
    Given User registers new user from api
    And User registers new patient with bp from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list

  @smoke @medicine @smoke
  Scenario: Add new customized Medicine to already registered patient
    Then User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page taps on Add another medicine button
    And User on Patient summary page add new customized medicine
    And User on Patient summary page verifies custum drug list
    And User on Patient summary page taps on save bp medicine button
#    Then User on Patient summary page verifies updated medicine info

  @smokey @medicine @smoke
  Scenario: User enter invalid data for customized medicine
    Then User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page taps on Add another medicine button
    And User on Patient summary page add new invalid customized medicine

  @smoke @medicine @smoke
  Scenario: Add new prescribed medicine to already registered patient
    Then User on Patient summary page taps on Add new medicine button
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies updated medicine info

  @regression @medicine1 @smoke
  Scenario: get all medicine info for specific facility form api and validate it in UI
    And User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page validate medicine info at bp medicine page
