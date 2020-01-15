Feature: Perform search for new Patient by ( name or phone number)

  @search  @smoke @all
  Scenario Outline: Search for new Patient by name
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searches for new Patient as <Name>
    Examples:
      | Name    |
      | newName |

  @search  @regression @all
  Scenario Outline: Search for new Patient by phoneNumber
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searches for new Patient Phonenumber as <PhoneNumber>
    Examples:
      | PhoneNumber |
      | 4444555555  |

  @search  @regression @all
  Scenario Outline: Search for new Patient by invalid phoneNumber
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searches for new Patient by invalid Phonenumber as <PhoneNumber>
    Examples:
      | PhoneNumber |
      | 4444        |