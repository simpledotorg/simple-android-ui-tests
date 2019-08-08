Feature: Select patient from recent patient list,update it's primary information or schedule an appointment
  verify display order in recent patient list.

  @updateRecentPatient @smoke
  Scenario: Add new Bp for patient whose name is listed in recent patient section
    Given User registers new user from api
    And User registers new patient with bp from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab select any patient from recent patient list
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab verifies patient info should show up on top of recent patient section

  @updateRecentPatient @smoke
  Scenario: Remove bp patient whose name is listed in recent patient section
    Given User registers new user from api
    And User registers new patient with bp from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab select any patient from recent patient list
    And User on Patient summary page taps on Edit Bp Link
    And User on Patient summary page taps on Remove Link
    And User on Patient summary page taps on remove button
    Then User on Patient summary page verifies message
    And User on Patient summary page taps on save Button
    And User on Patient tab verifies patient info should not show up on top of recent patient section

  @updateRecentPatient @smoke
  Scenario: upon Adding new medicine for patient,it's info should get displayed in recent patient section
    Given User registers new user from api
    And User registers new patient with bp from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab select any patient from recent patient list
    And User on Patient summary page taps on Add new medicine button
    And User on Patient summary page select prescribed medicine
    And User on Patient summary page taps on save bp medicine button
    Then User on Patient summary page verifies updated medicine info
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab verifies patient info should show up on top of recent patient section


  @updateRecentPatient @smoke
  Scenario: upon update appointment, verify patient name show up in recent patient list
    Given User registers new user from api
    And User registers new patient with bp from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab verifies patient info present in recent patients list
    And User on Patient tab select patient from recent patient list
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab verifies patient info should show up on top of recent patient section


  @updateRecentPatient  @smoke
  Scenario: upon editing patient information,verify patient name should not show up in recent patient section
    Given User registers new user from api
    And User registers new patient with bp from api
    And User taps on GetStarted button
    And User enters registered phone number
    And User enters registered security pin
    And User taps on Enter code link
    And User enters otp
    And User taps on Got It Button
    And User on Patient tab select any patient from recent patient list
    And User on Patient summary page taps on Edit patient info link
    And User on Patient summary page update patient info
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment not now button
    And User on Patient tab verifies patient info should not show up on top of recent patient section