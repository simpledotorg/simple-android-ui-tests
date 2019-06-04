Feature: Register Nurse

  @register  @smoke
  Scenario: Register New Nurse/User
    Given User Launches app
    And User taps on GetStarted button
    And User enters registration phone number
    And User enters registration name
    And User enters security pin number
    And User search for facility
    And User verifies homepage
    Then User verifies Patient tab
