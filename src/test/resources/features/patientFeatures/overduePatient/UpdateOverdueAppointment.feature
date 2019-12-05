Feature: Update Overdue appointment

  Background:
    Given User registers new user from api
    And User registers overdue patient
    And User LogsIn in app

  @updateAppointment @smoker1
  Scenario: update appointment with agreed to visit
    And User on Homepage taps on OVERDUE Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on agreed to visit reason
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on PATIENTS Tab
    And User on Patient tab taps on sync link

  @updateAppointment @smoke
  Scenario: update appointment with remind to call later
    And User on Homepage taps on OVERDUE Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on remind to call later
    And User on Overdue tab taps on done button
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on PATIENTS Tab
    And User on Patient tab taps on sync link
    And User on Patient tab verifies patient info should not show up on top of recent patient section

  @updateAppointment  @regression
  Scenario Outline: update appointment with other reason
    And User on Homepage taps on OVERDUE Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on remove from overdue list
    And User on Overdue tab selects <reasons>
    And User on Overdue reason page selects done button
#    And User enters registered security pin
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on PATIENTS Tab
    And User on Patient tab taps on sync link
    And User on Patient tab verifies patient info should not show up on top of recent patient section

    Examples:
      | reasons                                       |
      | Patient is not responding                     |
      | Transferred to another public health facility |
      | Moved to private practitioner                 |


  @updateAppointment  @regression
  Scenario Outline: verify Search for a patient whose appointment is updated as died
    And User on Homepage taps on OVERDUE Tab
    And User on Overdue tab taps on patient detail
    And User on Overdue tab taps on remove from overdue list
    And User on Overdue tab selects <reasons>
    And User on Overdue reason page selects done button
    And User enters registered security pin
    Then User on Overdue tab verifies patient info removed from overdue list
    And User on Homepage taps on PATIENTS Tab
    And User on Patient tab taps on sync link
    And User on Patient tab verifies patient info should not show up on top of recent patient section
    And User on Patient tab taps on search text box
    And User on Search page verfies patient name should not be displayed
    Examples:
      | reasons |
      | Died    |