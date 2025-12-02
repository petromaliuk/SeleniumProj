Feature: Login functionality

  Background:
    Given I open the login page

  Scenario Outline: Login with valid credentials
    When I login with username "<username>" and password "<password>"
    When I click login button
    Then I should see the credentials block

    Examples:
      | username    | password  |
      | petromaliuk | 16tolik16 |
