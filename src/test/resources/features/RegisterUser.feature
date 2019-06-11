Feature: Register Nurse

  @register  @smokey
  Scenario: Register New Nurse/User
    Given User Launches app
    And User taps on GetStarted button
    And User enters registration phone number
    And User enters registration name
    And User enters security pin number
    And User enters confirm pin number
    And User search for facility
    And User verifies homepage
    Then User verifies Patient tab

  @register  @smoke
    Scenario Outline: Register New Nurse/User with invalid phone number
      Given User Launches app
      And User taps on GetStarted button
      And User enters invalid registration phone number as <phoneNumber>
    Examples:
    |phoneNumber|
    |           |
    |     98988 |


   @register @smokey
     Scenario Outline: Register New Nurse/User with invalid confirm PIN
     Given User Launches app
     And User taps on GetStarted button
     And User enters registration phone number
     And User enters registration name
     And User enters security pin number
     And User enters invalid security pin as <PIN>
     Examples:
     |PIN|
     | 4321  |
     |       |


  @register @smokey
  Scenario: New Nurse/User reset pin at the time of registration
    Given User Launches app
    And User taps on GetStarted button
    And User enters registration phone number
    And User enters registration name
    And User enters invalid security pin as 4321
    And User taps on reset pin

   @register @smokey
     Scenario: Register New Nurse/User with invalid facility
     Given User Launches app
     And User taps on GetStarted button
     And User enters registration phone number
     And User enters registration name
     And User enters security pin number
     Then User search for invalid facility
     And User verifies error message
