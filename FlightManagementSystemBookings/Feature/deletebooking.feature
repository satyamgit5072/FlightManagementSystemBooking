Feature: Delete booking Test

Scenario: Delete an existing booking successfully
Given User is in the Home Page
When User clicks ViewAllBookings
And User clicks on the delete button on the existing bookings
Then User should see the message booking deleted succesfully.
