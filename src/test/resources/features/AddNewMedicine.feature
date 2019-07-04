Feature: Add New Medicine

  Background:
    Given User registers new user from api
    And User registers new patient with bp from api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list

  @smoke @medicine1
  Scenario: Add new customized Medicine to already registered patient
    Then User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page taps on Add another medicine button
    And User on Patient summary page add new customized medicine
    And User on Patient summary page verifies custum drug list
    And User on Patient summary page taps on save bp medicine button
#    Then User on Patient summary page verifies updated medicine info

  @smoke @medicine
  Scenario: Update customized Medicine to already registered patient
    Then User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page taps on Add another medicine button
    And User on Patient summary page add new customized medicine
    And User on Patient summary page taps on save bp medicine button
    And User on Patient summary page taps on Update Medicine info
    And User on Patient summary page select customize medicine
    And User on Patient summary page update medicine info
    And User on Patient summary page verifies custum drug list
    And User on Patient summary page taps on save bp medicine button
    #    Then User on Patient summary page verifies updated medicine info

  @smoke @medicine
  Scenario: Delete customized Medicine to already registered patient
    Then User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page taps on Add another medicine button
    And User on Patient summary page add new customized medicine
    And User on Patient summary page taps on save bp medicine button
    And User on Patient summary page taps on Update Medicine info
    And User on Patient summary page select customize medicine
    Then User on Patient summary page taps on remove custum prescription link
    And User on Patient summary page taps on cancel button
    Then User on Patient summary page taps on remove custum prescription link
    And User on Patient summary page taps on remove button
    And User on Patient summary page verifies custum drug list for deleted customized drug
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies add medicine button

  @smokey @medicine
  Scenario: User enter invalid data for customized medicine
    Then User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page taps on Add another medicine button
    And User on Patient summary page add new invalid customized medicine
    And User on Patient summary page taps on save bp medicine button

  @smoke @medicine
  Scenario: Add new medicine to already registered patient
    Then User on Patient summary page taps on Add new medicine button
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies updated medicine info

  @smoke @medicine
  Scenario: Update prescribed medicine
    Then User on Patient summary page taps on Add new medicine button
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    And User on Patient summary page taps on Update Medicine info
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies updated medicine info

  @smoke @medicine
  Scenario: remove prescribed medicine info
    Then User on Patient summary page taps on Add new medicine button
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    And User on Patient summary page taps on Update Medicine info
    Then User on Patient summary page taps on "None"
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies add medicine button

#  @regression @medicine @smoke
#  Scenario: get all medicine info for specific facility form api and validate it in UI
#    And User on Patient summary page taps on Add new medicine button
#    Then User on Patient summary page validate medicine info at bp medicine page

