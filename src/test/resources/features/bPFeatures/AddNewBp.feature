Feature: Add new Bp

  @bp1 @smoke @all
  Scenario: Add new BP to already registered patient
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page enters date
    And User on Patient summary page verifies days information
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab verifies patient info should show up on top of recent patient section

  @bp  @regression @all
  Scenario: Add new BP and phone number to already registered patient without phone number and BP
    Given User registers new user from api
    And  User registers new patient without phonenumber and bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on search page searched for Registered Patient without BP info
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page verifies update phone number pop up
    And User on Patient summary page enters phone number
    And User on Patient summary page verifies days information
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab verifies patient info should show up on top of recent patient section

  @bp  @regression @all
  Scenario: Add new BP to already registered patient without phone number
    Given User registers new user from api
    And User registers new patient without phonenumber from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page verifies update phone number pop up
    And User on Patient summary page taps on skip button
    And User on Patient summary page verifies days information
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab verifies patient info should show up on top of recent patient section

  @bp @regression @all
  Scenario: Add new BP with back date to already registered patient
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page enters back date
    And User on Patient summary page verifies days information for back date
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab verifies patient info should show up on top of recent patient section