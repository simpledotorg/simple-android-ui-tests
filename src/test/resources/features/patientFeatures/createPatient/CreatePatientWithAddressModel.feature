Feature:  To test Address Model

  Background:
    Given User registers new user from api
    And User LogsIn in app
    And User on Patient tab taps on search text box

  @createPatient @smoke @all
  Scenario : Verify Address page for different country
    And User on search page searches for new Patient name
    And User on search page taps on registered patient button
    Then User on Patient info entry page verifies address model for given country
