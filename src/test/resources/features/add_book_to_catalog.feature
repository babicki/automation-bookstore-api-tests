Feature: Try to add a book to the global catalog

  Scenario: Attempt to add a new book to the global book list
    When the user tries to add a new book to the global catalog
    Then the API should reject the request
