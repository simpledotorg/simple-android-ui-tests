Feature: Remove bp functionality testing

  @bp @smoke
  Scenario: Remove BP info for already registered patient who has only one bp recorded
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit Bp Link
    And User on Patient summary page taps on Remove Link
    And User on Patient summary page taps on cancel button
    And User on Patient summary page taps on Remove Link
    And User on Patient summary page taps on remove button
    Then User on Patient summary page verifies message
    And User on Patient summary page taps on save Button
    And User on Patient tab verifies patient info should show up on top of recent patient section
    And User on Patient tab taps on search text box
    Then User on search page searched for Registered Patient without BP info

  @bp @regression
  Scenario: Remove BP info to already registered patient who has more than one recorded bp.
    Given User registers new user from api
    And User registers a patient with multiple Bps
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit Bp Link
    And User on Patient summary page taps on Remove Link
    And User on Patient summary page taps on remove button
    Then User on Patient summary page verifies list of bp info
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab verifies patient info should show up on top of recent patient section


  @bp @regression
  Scenario: Remove BP and schedule appointment to already registered patient who has multiple recorded bp
    Given User registers new user from api
    And User registers a patient with multiple Bps
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit Bp Link
    And User on Patient summary page taps on Remove Link
    And User on Patient summary page taps on remove button
    Then User on Patient summary page verifies list of bp info
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment not now button
    And User on Patient tab verifies patient info should show up on top of recent patient section

  @bp @regression
  Scenario: Remove all Bp info for registered patient who has more than one bp recorded.
    Given User registers new user from api
    And User registers a patient with multiple Bps
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page removes all bp info
    Then User on Patient summary page verifies message
    And User on Patient summary page taps on save Button

  @bp @regression
  Scenario: End to End flow for Edit Bp and verify reflected changes in patient summary screen[with sync link]
    Given User registers new user from api
    And  User registers new patient with bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit Bp Link
    And User on Patient summary page taps on Remove Link
    And User on Patient summary page taps on remove button
    And User on Patient summary page taps on save Button
    And User on Patient tab taps on sync link
    And User on Patient tab select patient from recent patient list
    And User on Patient summary page verifies no bp present