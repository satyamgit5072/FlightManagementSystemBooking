Feature: Showing Available Flight Test

Scenario: Successful booking with valid credentials
Given User is on Home Page
When User clicks on the FlightBooking
And User selects the Source Airport
And User selects the Destination Airport
And User selects the date on which he wants to travel
Then User should see a available flights on that day.
