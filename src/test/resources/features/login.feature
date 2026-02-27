Feature: User login

  Scenario: Successful login
    Given the user sends a valid login request
    Then the response status code should be 200
    And the response should contain an authentication token