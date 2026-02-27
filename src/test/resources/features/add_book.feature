Feature: Add a book to the user's collection

  Scenario: Add a book from the catalog to the user's collection
    Given the user is logged in for adding a book
    When the user adds a book from the catalog to their collection
    Then the book should be added successfully