Feature: Register Nurse

  @register
  Scenario Outline: Register New Nurse/User
    And User taps on GetStarted button
    And User enters registration phone number
    And User enters registration name
    And User enters security pin number
    And User enters confirm pin number
    And User search for facility as <facilityName>
    And User verifies homepage
    Then User verifies Patient tab
    Examples:
    |facilityName|
    | CHC Bagta  |

  @register  @smoke
    Scenario Outline: Register New Nurse/User with invalid phone number
      And User taps on GetStarted button
      And User enters invalid registration phone number as <phoneNumber>
    Examples:
    |phoneNumber|
    |           |
    |     98988 |


   @register @smokey
     Scenario Outline: Register New Nurse/User with invalid confirm PIN
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
    And User taps on GetStarted button
    And User enters registration phone number
    And User enters registration name
    And User enters security pin number
    And User enters invalid security pin as 4321
    And User taps on reset pin

   @register1 @smokey
     Scenario: Register New Nurse/User with invalid facility
     And User taps on GetStarted button
     And User enters registration phone number
     And User enters registration name
     And User enters security pin number
     And User enters confirm pin number
     Then User search for invalid facility

  @recentPatient
  Scenario Outline: verify no recent patient text
    And User taps on GetStarted button
    And User enters registration phone number
    And User enters registration name
    And User enters security pin number
    And User enters confirm pin number
    And User search for facility as <facilityName>
    And User on Patient tab verifies no recent patient text
    Examples:
    |facilityName|
    |CHC Buccho  |