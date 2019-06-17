Feature: Add protocol drug

  @smoke @custom_drug
  Scenario: create drug from api and validate it in UI
    Given User Registers New User through API
    And User Registers New Patient through API
    And User Registers New Bp record through API
    And User create protocol drug from api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searched for Registered Patient
    And User select patient form search list
    Then User on patient summary detail page verifies medicine info
    And User taps on Add new medicine button
    Then User verifies custum drug list