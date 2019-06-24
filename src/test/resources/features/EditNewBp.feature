Feature: Edit BP info

  @editBp @smoke
  Scenario:Edit BP info to already registered patient
    Given User registers new user from api
    And User registers new patient with bp from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit Bp Link
    And User on Patient summary page updates Bp Info
    And User on Patient summary page taps on next ArrowButton
    And User on Patient summary page enters date
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment
    Then User on Patient tab verifies patient info present in recent patients list


  @editBp @smoke
  Scenario:Remove BP info for already registered patient
    Given User registers new user from api
    And User registers new patient with bp from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
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
    Then User on Search page searched for Registered Patient without BP info


  @editBp @smoke
  Scenario: Edit BP info to already registered patient who has more than one recorded bp.
    Given User registers new user from api
    And User register new patient with list of bp through api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit Bp Link
    And User on Patient summary page updates Bp Info
    And User on Patient summary page taps on next ArrowButton
    And User on Patient summary page enters date
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment


  @editBp1 @smoke
  Scenario: Remove BP info to already registered patient who has more than one recorded bp.
    Given User registers new user from api
    And User register new patient with list of bp through api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit Bp Link
    And User on Patient summary page taps on Remove Link
    And User on Patient summary page taps on remove button
    Then User on Patient summary page verifies list of bp info

  @editBp @smoke
  Scenario:Remove all Bp info for registered patient who has more than one bp recorded.
    Given User registers new user from api
    And User register new patient with list of bp through api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page removes all bp info
    Then User on Patient summary page verifies message
