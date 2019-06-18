Feature: Add new Bp

  @addbp @smoke
  Scenario: Add new BP to already registered patient

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
    And User taps on Add new Bp button
    And User enters new Bp Info
    And User taps on next ArrowButton
    And User enters date
    And User taps on save Button
    And User taps on appointment
#    Then User verifies recent patients list


  @addbp    @smoke
  Scenario: Add new BP and phone number to already registered patient without phone number and BP
    Given User registers new user through api
    And User registers new patient without phonenumber through api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searched for Registered Patient without BP info
    And User select patient form search list
    And User taps on Add new Bp button
    And User enters new Bp Info
    And User taps on next ArrowButton
    And User enters date
    And User taps on save Button
    And User verifies update phone number pop up
    And User enters phone number
    And User taps on save Button
    And User taps on appointment
#    Then User verifies recent patients list


  @addbp  @smoke
  Scenario: Add new BP to already registered patient without phone number

    Given User registers new user through api
    And User registers new patient without phonenumber through api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    Then User searched for Registered Patient
    And User select patient form search list
    And User taps on Add new Bp button
    And User enters new Bp Info
    And User taps on next ArrowButton
    And User enters past date
    And User taps on save Button
    And User verifies update phone number pop up
    And User taps on skip button
    And User taps on save Button
    And User taps on appointment
#    Then User verifies recent patients list


  @addbp @smoke
  Scenario: Add new BP with past date to already registered patient
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
    And User taps on Add new Bp button
    And User enters new Bp Info
    And User taps on next ArrowButton
    And User enters past date
    And User verifies days information
    And User taps on save Button
    And User taps on appointment


