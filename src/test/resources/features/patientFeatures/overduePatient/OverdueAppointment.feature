Feature: overdue PATIENTS test

  Background:
    Given User registers new user from api
    And User registers overdue patient
    And User LogsIn in app

  @overdue @smoke
  Scenario: create overdue patient from api and validate it in ui
    And User on Homepage taps on overdue Tab
    Then User on Overdue Tab verifies patient info present in overdue list

  @overdue @smoke
  Scenario: user should be able to view information for overdue patient
    And User on Homepage taps on overdue Tab
    And User on Overdue tab taps on patient detail
    Then User on Overdue tab verifies expanded view of patient information

  @overdue @smoke
  Scenario: add new bp for an overdue patient
    And User on Patient tab taps on search text box
    And User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link
    And User on Homepage taps on overdue Tab
    Then User on Overdue tab verifies patient info removed from overdue list

  @overdue @smoke @regression
  Scenario Outline:End to end flow of adding bp for a patient whose appointment is updated with Phone number doesn't exist
    And User on Homepage taps on overdue Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on remove from overdue list
    And User on Overdue tab selects <reasons>
    And User on Overdue reason page selects done button
    And User enters registered security pin
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on Patients Tab
    And User on Patient tab verifies patient info should not show up on top of recent patient section
    And User on Patient tab taps on search text box
    And User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page updates phone number
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link

    Examples:
      | reasons                    |
      | Phone number does not work |

  @overdue @smoke @regression
  Scenario Outline:End to end flow for a patient whose appointment is updated with Phone number doesn't exist
    And User on Homepage taps on overdue Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on remove from overdue list
    Then User on Overdue tab Verifies reason screen
    And User on Overdue tab selects <reasons>
    And User on Overdue reason page selects done button
    And User enters registered security pin
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on Patietns Tab
    And User on Patient tab verifies patient info should not show up on top of recent patient section
    And User on Patient tab taps on search text box
    And User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page verifies update phone number pop up
    And User on Patient summary page taps on skip button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on sync link

    Examples:
      | reasons                    |
      | Phone number does not work |

  @overdue @smoke
  Scenario: Verify Call pop up
    And User on Homepage taps on overdue Tab
    And User on Overdue tab taps on call Icon
    Then User on Overdue tab verifies popup