Feature: Miscellaniuos feature

  @overdue @smoke
  Scenario: Verify patient info for whose appointment is scheduled for today
    Given User registers new user from api
    Given User creates overdue patient with appointment as of today
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

  @custom_drug
  Scenario: create drug from api and validate it in UI
    Given User registers new user from api
    And User registers new patient with bp from api
    And User create protocol drug from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab taps on search text box
    Then User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    Then User on patient summary detail page verifies medicine info
    And User on Patient summary page taps on Update Medicine info
    Then User on Patient summary page verifies custum drug list

