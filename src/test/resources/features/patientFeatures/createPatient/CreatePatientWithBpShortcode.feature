Feature: Create patient with Bp shortcode

  @createPatient @bpshortcode  @smoke1 @all
  Scenario: verify registered patient with bp passport
    Given User registers new user from api
    And User registers new patient with bp passport from api
    And User LogsIn in app
    And User on Patient tab taps on search text box
    And User on Search page searched for Registered Patient
    And User on Search page selects patient form search list
    And User on Patient summary page verifies bp passport





