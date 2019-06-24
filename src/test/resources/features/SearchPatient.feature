Feature: Search for Patient information

  @search  @smoke
  Scenario Outline:Search for unregistered Patient
    Given User registers new user from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searches for unregistered Patient as <invalid>
    Examples:
    |invalid|
    |invalidData|


  @search  @smoke
  Scenario: Search for patient without BP info
    Given User registers new user from api
    And User registers new patient without bp from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient without BP info

  @search  @smoke
  Scenario: Search for patient with BP info
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