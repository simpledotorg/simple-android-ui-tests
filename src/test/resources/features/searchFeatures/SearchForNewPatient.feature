Feature: Perform search for new Patient by ( name or phone number)

  @search  @smoke
  Scenario Outline: Search for new Patient by name
    Given User registers new user from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searches for new Patient as <Name>
    Examples:
      | Name    |
      | newName |

  @search  @smoke
  Scenario Outline: Search for new Patient by phoneNumber
    Given User registers new user from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searches for new Patient Phonenumber as <PhoneNumber>
    Examples:
      | PhoneNumber |
      | 4444        |
