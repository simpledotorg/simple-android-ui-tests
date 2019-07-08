Feature: overdue patients test

  Background:
    Given User registers new user from api
    And User registers overdue patient
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button

  @overdue @smoke
  Scenario: create overdue patient from api and validate it in ui
    And User on Homepage taps on Overdue Tab
    Then User on Overdue Tab verifies patient info present in overdue list


  @overdue @smoke
  Scenario: user should be able to view information for overdue patient
    And User on Homepage taps on Overdue Tab
    And User on Overdue tab taps on patient detail
    Then User on Overdue tab verifies expanded view of patient information

  @overdue @smoke
  Scenario: update appointment with agreed to visit
    And User on Homepage taps on Overdue Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on agreed to visit reason
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on Patients Tab
    And User on Patient tab taps on sync link

  @overdue @smoke
  Scenario: add new bp for an overdue patient
    And User on Homepage taps on Overdue Tab
    Then User on Overdue Tab verifies patient info present in overdue list
    And User on Homepage taps on Patients Tab
    And User on Patient tab taps on search text box
    And User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page taps on next ArrowButton
    And User on Patient summary page enters date
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Homepage taps on Overdue Tab
    Then User on Overdue tab verifies patient info removed from overdue list

  @overdue @smoke
  Scenario: update appointment with remind to call later
    And User on Homepage taps on Overdue Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on remind to call later
    And User on Overdue tab taps on done button
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on Patients Tab
    And User on Patient tab taps on sync link
    And User on Patient tab verifies patient info should not show up on top of recent patient section


  @overdue @smoke
  Scenario Outline:End to end flow of adding bp for a patient whose appointment is updated with Phone number doesn't exist
    And User on Homepage taps on Overdue Tab
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

  @overdue @smoke
  Scenario Outline:End to end flow for a patient whose appointment is updated with Phone number doesn't exist
    And User on Homepage taps on Overdue Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on remove from overdue list
    Then User on Overdue tab Verifies reason screen
    And User on Overdue tab selects <reasons>
    And User on Overdue reason page selects done button
    And User enters registered security pin
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on Patients Tab
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
  Scenario Outline: update appointment with other reason
    And User on Homepage taps on Overdue Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on remove from overdue list
    And User on Overdue tab selects <reasons>
    And User on Overdue reason page selects done button
    And User enters registered security pin
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on Patients Tab
    And User on Patient tab taps on sync link
    And User on Patient tab verifies patient info should not show up on top of recent patient section

    Examples:
      |reasons |
      |Patient is not responding |
      |Transferred to another public health facility|
      |Moved to private practitioner|

  @overdue @smoke
  Scenario: Verify Call pop up
    And User on Homepage taps on Overdue Tab
    And User on Overdue tab taps on call Icon
    Then User on Overdue tab verifies popup


  @overdue @smoke
  Scenario Outline: verify Search for a patinet whose appointment is updated as dead
    And User on Homepage taps on Overdue Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on remove from overdue list
    And User on Overdue tab selects <reasons>
    And User on Overdue reason page selects done button
    And User enters registered security pin
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on Patients Tab
    And User on Patient tab taps on sync link
    And User on Patient tab verifies patient info should not show up on top of recent patient section
    And User on Patient tab taps on search text box
    And User on Search page verfies patient name should not be displayed
    Examples:
      | reasons |
      | Died    |


