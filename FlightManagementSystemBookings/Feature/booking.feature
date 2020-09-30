Feature: Showing Available Flight Test

Scenario: Successful booking with valid credentials
Given User is in the home page of the application
When User clicks FlightBooking
And User enters Source Airport
And User enters Destination Airport
And User enters the date on which he wants to travel
And User clicks search button
And User clicks repestive available flight for which he want to book
And User enters the passenger details 
And User clicks the conform booking button 
And User clicks ok on the alert box showing flight booking successfull 
Then User should see the booked ticket deatails.
