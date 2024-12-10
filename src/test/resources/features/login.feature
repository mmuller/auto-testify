@regresion
Feature: Login functionality

  Scenario Outline: Login with valid credentials
    Given I am on the login page
    When I enter credentials for valid user <userIndex>
    When I should see the products page
    And I sign out

    Examples:
      | userIndex |
      | 1         |
      | 2         |
      | 3         |
      | 4         |

  Scenario Outline: Login with invalid credentials
    Given I am on the login page
    When I enter credentials for invalid user <userIndex>
    Then I should see the error message for invalid user <userIndex>

    Examples:
      | userIndex |
      | 1         |
      | 2         |
      | 3         |
      | 4         |

