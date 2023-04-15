Feature: Just Checking sample project

  @Sample
  Scenario: Logging into google Website
    Given User logged into Sample Website
    When user logged in with Username and password
    Then Verify user is on Sample website

  @Sample
  Scenario Outline: Logging into google Website
    Given User logged into Sample Website
    When user logged in with "<Username>" and "<password>"
    Then Verify user is on Sample website
    Examples:
      | Username | password |
      | Anil     | 9010     |



