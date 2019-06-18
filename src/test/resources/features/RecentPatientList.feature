Feature: Recent patient list


  @recentPatient @smoke
  Scenario: User  verifies recent patient list
    Given User registers new user through api
    And User registers new patient with bp from api
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User verifies SEE ALL option