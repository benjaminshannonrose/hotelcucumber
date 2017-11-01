Feature: user account creation

  Background:
    Given user 'lands on' the 'index page'
    When user 'clicks sign up link' on the 'index page'

  Scenario: intentional fail to test screenshot capture
    Then scenario should fail

  Scenario: user signs up with valid username, valid password, and matching confirmation password
    And user enters 'newvalidusername' 'into the username textbox' on the 'sign up page'
    And user enters 'newvalidpassword' 'into the password textbox' on the 'sign up page'
    And user enters 'newvalidpassword' 'into the confirmation textbox' on the 'sign up page'
    And user 'clicks sign up button' on the 'sign up page'
    Then user 'lands on' the 'login page'

  Scenario: user signs up with too short of username, too short of password, and unmatching confirmation password
    And user enters 'short' 'into the username textbox' on the 'sign up page'
    And user enters 'short' 'into the password textbox' on the 'sign up page'
    And user enters 'newvalidpassword' 'into the confirmation textbox' on the 'sign up page'
    And user 'clicks sign up button' on the 'sign up page'
    Then there should be a 'username error message' on the 'sign up page'
    And there should be a 'password error message' on the 'sign up page'
    And there should be a 'confirm password error message' on the 'sign up page'

  Scenario: user signs up with a taken username, but other credentials are valid
    And user enters 'realname' 'into the username textbox' on the 'sign up page'
    And user enters 'newvalidpassword' 'into the password textbox' on the 'sign up page'
    And user enters 'newvalidpassword' 'into the confirmation textbox' on the 'sign up page'
    And user 'clicks sign up button' on the 'sign up page'
    Then there should be a 'username error message' on the 'sign up page'



