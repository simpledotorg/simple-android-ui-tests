Feature: Add New Medicine

  Background:
    Given User registers new user through api
    And User registers new patient with bp from api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searched for Registered Patient
    And User select patient form search list

  @smoke @medicine
  Scenario: Add new customized Medicine to already registered patient
    Then User taps on Add new medicine button
    Then User taps on Add another medicine button
    And User add new customized medicine
    And User verifies custum drug list
    And User taps on save bp medicine button
#    Then User verifies updated medicine info

  @smoke @medicine
  Scenario: Update customized Medicine to already registered patient
    Then User taps on Add new medicine button
    Then User taps on Add another medicine button
    And User add new customized medicine
    And User taps on save bp medicine button
    And User taps on Update Medicine info
    And User select customize medicine
    And User update medicine info
    And User verifies custum drug list
    And User taps on save bp medicine button
#    Then User verifies updated medicine info

  @smoke @medicine
  Scenario: Delete customized Medicine to already registered patient
    Then User taps on Add new medicine button
    Then User taps on Add another medicine button
    And User add new customized medicine
    And User taps on save bp medicine button
    And User taps on Update Medicine info
    And User select customize medicine
    Then User taps on remove custum prescription link
    And User taps on cancel button
    Then User taps on remove custum prescription link
    And User taps on remove button
    And User verifies custum drug list for deleted customized drug
    And User taps on save bp medicine button
    Then User verifies add medicine button

  @smoke @medicine
  Scenario: User enter invalid data for customized medicine
    Then User taps on Add new medicine button
    Then User taps on Add another medicine button
    And User add new invalid customized medicine
    And User taps on save bp medicine button

  @smoke @medicine
  Scenario: Add new medicine to already registered patient
    Then User taps on Add new medicine button
    And User select prescribed medicine
    And User taps on save bp medicine button
    Then User verifies updated medicine info

  @smoke @medicine
  Scenario: Update prescribed medicine
    Then User taps on Add new medicine button
    And User select prescribed medicine
    And User taps on save bp medicine button
    And User taps on Update Medicine info
    And User select prescribed medicine
    And User taps on save bp medicine button
    Then User verifies updated medicine info

  @smoke @medicine
  Scenario: remove prescribed medicine info
    Then User taps on Add new medicine button
    And User select prescribed medicine
    And User taps on save bp medicine button
    And User taps on Update Medicine info
    Then User taps on "None"
    And User taps on save bp medicine button
    Then User verifies add medicine button

  @regression @medicine
  Scenario: get all medicine info for specific facility form api and validate it in UI
    And User taps on Add new medicine button
    Then User validate medicine info at bp medicine page

