Feature: booking information Test

Scenario: viewing every information about booking successfully
Given User in Home Page
When User clicks the ViewAllBookings
And User clicks on the particular get booking button
Then User should see the complete information of the booking.
