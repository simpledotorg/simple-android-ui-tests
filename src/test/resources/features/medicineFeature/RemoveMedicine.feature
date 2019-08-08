Feature: Remove medicine info from Patient summary page

  Background:
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

  @removeMedicine @medicine @smoke
  Scenario: remove prescribed medicine info
    Then User on Patient summary page taps on Add new medicine button
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    And User on Patient summary page taps on Update Medicine info
    Then User on Patient summary page taps on "None"
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies add medicine button


  @removeMedicine @medicine @smoke
  Scenario: Delete customized Medicine to already registered patient
    Then User on Patient summary page taps on Add new medicine button
    Then User on Patient summary page taps on Add another medicine button
    And User on Patient summary page add new customized medicine
    And User on Patient summary page taps on save bp medicine button
    And User on Patient summary page taps on Update Medicine info
    And User on Patient summary page select customize medicine
    Then User on Patient summary page taps on remove custum prescription link
    And User on Patient summary page taps on cancel button
    Then User on Patient summary page taps on remove custum prescription link
    And User on Patient summary page taps on remove button
    And User on Patient summary page verifies custum drug list for deleted customized drug
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies add medicine button
