Feature: booking hotels

  Background:
    Given user 'lands on' the 'index page'

  Scenario: user enters zip code to search for hotels
    When user enters '43016' 'into the hotel search bar' on the 'index page'
    And user 'clicks search button' on the 'index page'
    Then user should see list of hotels

  Scenario: user enters city and state to search for hotels
    When user enters 'Atlanta GA' 'into the hotel search bar' on the 'index page'
    And user 'clicks search button' on the 'index page'
    Then user should see list of hotels

  Scenario: user clicks book hotel button while not signed in
    When user enters '43016' 'into the hotel search bar' on the 'index page'
    And user 'clicks search button' on the 'index page'
    And user 'clicks book hotel button' on the 'index page'
    Then user 'lands on' the 'login page'

  Scenario: user logs in and then logs out from bookings page
    When user 'clicks login link' on the 'index page'
    And user enters 'bookingslogout' 'into the username textbox' on the 'login page'
    And user enters '123456789' 'into the password textbox' on the 'login page'
    And user 'clicks login button' on the 'login page'
    And user 'clicks view bookings link' on the 'index page'
    And user 'clicks log out link' on the 'bookings page'
    Then user 'lands on' the 'login page'


  Scenario: user clicks book hotel button while signed in and checks their bookings
    When user 'clicks login link' on the 'index page'
    And user enters 'bookinguser' 'into the username textbox' on the 'login page'
    And user enters '123456789' 'into the password textbox' on the 'login page'
    And user 'clicks login button' on the 'login page'
    And user enters '43016' 'into the hotel search bar' on the 'index page'
    And user 'clicks search button' on the 'index page'
    And user 'clicks book hotel button' on the 'index page'
    And user 'clicks book hotel button' on the 'index page'
    And user 'clicks view bookings link' on the 'index page'
    Then they should see both bookings

  Scenario: user views the google map associated a booking
    When user 'clicks login link' on the 'index page'
    And user enters 'mapusername' 'into the username textbox' on the 'login page'
    And user enters '123456789' 'into the password textbox' on the 'login page'
    And user 'clicks login button' on the 'login page'
    And user 'clicks view bookings link' on the 'index page'
    And user 'clicks view booking button' on the 'bookings page'
    Then they should see a google map of the hotel with details
    And they should be able to close the map

  Scenario: user deletes a booking
    When user 'clicks login link' on the 'index page'
    And user enters 'deleteusergit' 'into the username textbox' on the 'login page'
    And user enters '123456789' 'into the password textbox' on the 'login page'
    And user 'clicks login button' on the 'login page'
    And user 'clicks view bookings link' on the 'index page'
    Then they should no longer see a booking after they click the button to delete it