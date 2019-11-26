Feature: miscellaneous feature -Patinet sync in different facility

  @smoke
  Scenario: Verify patient info sync in different facility
    Given User registers new user from api
    And User registers new patient with bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility

  @smoke
  Scenario: Verify patient info sync in different facility -patient without bp
    Given User registers new user from api
    And User registers new patient without bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutBp

  @smoke
  Scenario: Verify patient info sync in different facility -patient with bp passport
    Given User registers new user from api
    And User registers new patient with bp passport from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withbpPassport

  @smoke
  Scenario: Verify patient info sync in different facility -patient without phonenumber and bp
    Given User registers new user from api
    And User registers new patient without phonenumber and bp from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutPhonenumberAndBp

  @smoke
  Scenario: Verify patient info sync in different facility-patient without phonenumber
    Given User registers new user from api
    And User registers new patient without phonenumber from api
    And User LogsIn in app with new user in different facility
    And User on Patient tab taps on search text box
    And User on search page searched for patient registered in other facility for withoutPhonenumber


