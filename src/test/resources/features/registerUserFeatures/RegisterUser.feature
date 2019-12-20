Feature: Register Nurse/User

  @register @smoke
  Scenario Outline: Register New Nurse/User
    And New User registers on app
    And User search for facility as <facilityName>
    And User verifies homepage
    Then User verifies Patient tab
    Examples:
      | facilityName |
      | CHC Bagta    |

  @register @regression
  Scenario: New Nurse/User reset pin at the time of registration
    And User taps on GetStarted button
    And User selects country
    And User enters registration phone number
    And User enters registration name
    And User enters security pin number
    And User enters invalid security pin as 4321
    And User taps on reset pin

  @register @smoke
  Scenario Outline: verify no recent patient text
    And New User registers on app
    And User search for facility as <facilityName>
    And User on Patient tab verifies no recent patient text
    Examples:
      | facilityName |
      | CHC Buccho   |


  @setting  @register @regression
  Scenario Outline: User should be able to select language while new registration
    And New User registers on app
    And User search for facility as <facilityName>
    And User taps on setting Icon
    And User taps on change button
    Then User taps on Done button and verify language selection <lang>
    Examples:
      | facilityName | lang    |
      | CHC Buccho   | English |

  @smoke
  Scenario Outline: Verify patient info sync in different facility - registration flow
    Given User registers new user from api
    And User registers new patient with bp from api
    And New User registers on app
    And User search for facility as <facilityName>
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility
    Examples:
      | facilityName |
      | CHC Buccho   |