Feature: Test setting screen functionality

  Background:
    Given User registers new user from api
    And User LogsIn in app
    And User taps on setting Icon

  @setting @smoke1 @all
  Scenario Outline: User should be able to select language

    And User taps on change button
    Then User taps on Done button and verify language selection <lang>

    Examples:
      | lang    |
      | English |

  @setting @regression @all
  Scenario: Verify default text for language setting when user didn't select any language

    Examples:
    And User taps on change button
    And User navigates back
    Then User verifies default text for lang setting

