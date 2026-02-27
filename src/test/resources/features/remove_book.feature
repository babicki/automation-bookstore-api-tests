Feature: Remove a book from the user's collection

  Scenario: Remove a book from the user's collection
    Given the user is logged in for removing a book
    When the user removes a book from their collection
    Then the book should be removed successfully
