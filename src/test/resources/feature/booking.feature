Feature: Search for hotel
  Scenario Outline: User goes to main page search hotel <name> and check <rating>
    Given Main Booking page opened
    When User type name hotel <name>
    And Find hotel by "Search"
    Then Check hotel name <name> and rating <rating> respond
    Examples:
      | name                         | rating |
      | "Antonio Old Town Residence" | "8.2"  |