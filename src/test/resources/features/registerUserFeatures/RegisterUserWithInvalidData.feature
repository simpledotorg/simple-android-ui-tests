Feature: Register Nurse/User with invalid data

  @invalid  @smoke
  Scenario Outline: Register New Nurse/User with invalid phone number
    And User taps on GetStarted button
    And User enters invalid registration phone number as <phoneNumber>
    Examples:
      | phoneNumber |
      |             |
      | 98988       |


  @invalid1 @smoke
  Scenario Outline: Register New Nurse/User with invalid confirm PIN
    And User taps on GetStarted button
    And User enters registration phone number
    And User enters registration name
    And User enters security pin number
    And User enters invalid security pin as <PIN>
    Examples:
      | PIN  |
      | 4321 |
      |      |

  @invalid @smoke
  Scenario: Register New Nurse/User with invalid facility
    And User taps on GetStarted button
    And User enters registration phone number
    And User enters registration name
    And User enters security pin number
    And User enters confirm pin number
    Then User search for invalid facility
