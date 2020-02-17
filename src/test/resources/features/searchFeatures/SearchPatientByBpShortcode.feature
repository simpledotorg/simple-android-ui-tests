Feature: Search for Patient information by shortcode

  @search @smoke1 @all
  Scenario: search for a registered patient by shortcode
    Given User registers new user from api
    And User registers new patient with bp passport from api
    And User LogsIn in app
    And User on Patient tab taps on Scan Bp passport
    And User on ScanCard Page verifies page
    And User on ScanCard Page enters valid bpshortcode value
    And User on Search page verifies result for registered patient with bpPassport