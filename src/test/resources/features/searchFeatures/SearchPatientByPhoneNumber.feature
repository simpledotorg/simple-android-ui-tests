Feature: Search for Patient information by phone number

  @search @smoke1  @all
  Scenario: search by phone number
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on search page searched for Registered Patient by phone Number
    And User on Search page selects patient form search list
    Then User on Patient summary page verifies phone number

  @search  @regression @all
  Scenario: Search patient by duplicate phone number
    Given User registers new user from api
    And User registers multiple patients with same phoneNumber from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on search page verifies search result for duplicate phoneNumber

  @search  @regression @all
  Scenario: add new phoneNumber to patients primary info and then search by registered phone number
    Given User registers new user from api
    And User registers new patient without phonenumber from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page taps on Edit patient info link
    And User on Patient summary page add new phone number
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on search text box
    And User on search page searched for Registered Patient by phone Number

  @search  @regression @all
  Scenario Outline: Search by unregistered phone number and create new patient
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    Then User on Search page searches for new Patient Phonenumber as <PhoneNumber>
    And User on search page taps on registered patient button
    And User on patient summary page verifies phoneNumber prefill
    And User on Patient summary page enters new patient primary information
    And User on Diagnosis page taps on next Button
    And User on Patient summary page taps on Add new Bp button
    And User on Patient summary page enters new Bp Info
    And User on Patient summary page selects done button
    And User on Patient summary page taps on save Button
    And User on Patient summary page taps on appointment done button
    And User on Patient tab taps on search text box
    And User on search page searched for Registered Patient by phone Number
    Examples:
      | PhoneNumber |
      | 4444444444  |

  @search  @regression @all
  Scenario: search by phone number for patient with multiple bps
    Given User registers new user from api
    And User registers a patient with multiple Bps
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on search page searched for Registered Patient by phone Number
    And User on Search page selects patient form search list
    Then User on Patient summary page verifies phone number