Feature: Booking Round trip tickets

@Demo
Scenario: Ticket booking till payment page



     Given   Guest opens cleartrip website homepage
When Guest selects round trip
   And     Guest gives booking  details of the trip
  And      Guest searches for the available flights
   Then     Guest verifies selection details and clicks on book flight
      And Guest verifies the itinerary details , accepts terms and conditions and continues booking
     When   Guest enters email address and continues booking
     And   Guest enters traveller details and continues booking