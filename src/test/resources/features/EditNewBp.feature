Feature: Edit BP info

  @edit @smoke
  Scenario:Edit BP info to already registered patient
    Given User registers new user through api
    And User registers new patient with bp from api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searched for Registered Patient
    And User select patient form search list
    And User taps on Edit Bp Link
    And User updates Bp Info
    And User taps on next ArrowButton
    And User enters date
    And User taps on save Button
    And User taps on appointment
    Then User verifies recent patients list


  @edit @smoke
  Scenario:Remove BP info for already registered patient
    Given User registers new user through api
    And User registers new patient with bp from api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searched for Registered Patient
    And User select patient form search list
    And User taps on Edit Bp Link
    And User taps on Remove Link
    And User taps on cancel button
    And User taps on Remove Link
    And User taps on Remove button
    Then User verifies message
    And User taps on save Button
    Then User searched for Registered Patient without BP info


  @edit @smoke
  Scenario: Edit BP info to already registered patient who has more than one recorded bp.
    Given User registers new user through api
    And User register new patient with list of bp through api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searched for Registered Patient
    And User select patient form search list
    And User taps on Edit Bp Link
    And User updates Bp Info
    And User taps on next ArrowButton
    And User enters date
    And User taps on save Button
    And User taps on appointment


  @edit @smoke
  Scenario: Remove BP info to already registered patient who has more than one recorded bp.
    Given User registers new user through api
    And User register new patient with list of bp through api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searched for Registered Patient
    And User select patient form search list
    And User taps on Edit Bp Link
    And User taps on Remove Link
    And User taps on Remove button
    Then User verifies list of bp info

  @edit @smoke
  Scenario:Remove all Bp info for registered patient who has more than one bp recorded.
    Given User registers new user through api
    And User register new patient with list of bp through api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searched for Registered Patient
    And User select patient form search list
    And User removes all bp info
    Then User verifies message
