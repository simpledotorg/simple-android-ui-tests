Feature: Search for Patient information

  @search  @smoke
  Scenario Outline:Search for unregistered Patient
    Given User registers new user through api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searches for unregistered Patient as <invalid>
    Examples:
    |invalid|
    |invalidData|


  @search  @smoke
  Scenario: Search for patient without BP info
    Given User registers new user through api
    And User registers new patient without bp from api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searched for Registered Patient without BP info

  @search  @smoke
  Scenario: Search for patient with BP info
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