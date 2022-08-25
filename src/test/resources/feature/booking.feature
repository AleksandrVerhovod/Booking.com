Feature: Search for hotel
  Scenario: Search for Antonio Old Town Residence
    Given Main Booking page opened
    When User type name hotel "Antonio Old Town Residence"
    And Find hotel by "Search"
    Then Check name "Antonio Old Town Residence" and rating "8.2" respond
