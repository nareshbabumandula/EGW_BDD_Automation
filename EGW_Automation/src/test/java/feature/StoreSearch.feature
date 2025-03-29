@regression
Feature: MTN Home Page Feature

  @smoke
  Scenario: Verify the functionality of searching an eyeglass store based on 'City' name
    Given I access eyeglassworld portal
    When I enter the city name as "tampa" in the store search text field
    And I click on search button
    Then I should see the appropriate search results
  