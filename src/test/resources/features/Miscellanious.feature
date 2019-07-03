Feature: Miscellaniuos feature

  @overdue @smoke
  Scenario: Verify patient info for whose appointment is scheduled for today
    Given User registers new user from api
    Given User registers new patient with bp from api
    Given User creates overdue patient with appointment as of today
    And User Launches app
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Homepage taps on Overdue Tab
    Then User on Overdue tab verifies patient info is not present in list
    And User on Homepage taps on Patients Tab
    And User on Patient tab taps on sync link
