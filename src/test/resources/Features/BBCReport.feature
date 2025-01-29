Feature: BBC Report

  Scenario: As a BBC editor, I want to accurately report the results of the 2023 Las Vegas Grand Prix, where Max
  Verstappen took 1st place, George Russell finished 2nd, and Sergio Perez secured 3rd place, so that my
  audience is informed about the key highlights of the race

    Given The user is in the BBC Landing page
    And The user has selected the Formula one
    And The user has selected the Results
    And The user has selected the year to report on
    And The user collapse the currently opened results
    When The user click on the Las Vegas Grand Prix, Las Vegas Street Circuit
    Then The Results table should be displayed
    And The user validate that Max Verstappen took 1st place
    And The user validate that George Russell finished 2nd
    And The user validate that Sergio Perez secured 3rd place


  @search
  Scenario: Validate search results for "Sport in 2023"
    Given The user is in the BBC Landing page
    And I click the search icon
    When I search "Sport in 2023"
    Then The search results are displayed
    And The relevant search results are displayed









