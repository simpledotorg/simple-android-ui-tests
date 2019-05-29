Feature: Search for Patient information

  Background:
    Given User Registers New User through API
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button

  @search
  Scenario:Search patient with invalid data
   And User searches for unregistered Patient

