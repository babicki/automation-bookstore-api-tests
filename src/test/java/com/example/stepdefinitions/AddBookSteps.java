package com.example.stepdefinitions;

import com.example.api.AuthService;
import com.example.api.CommonRequest;
import com.example.data.UserCredentials;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.*;

/**
 * Step definitions for adding books.
 * Implements Gherkin steps from add_book.feature.
 * Handles login, selecting a book, and adding it to the user's collection.
 */
public class AddBookSteps {

    private Response response;
    private String token;
    private String userId;
    private String isbn;

    /**
     * Logs in a user for book operations.
     * Saves the token and user ID for further requests.
     */
    @Given("the user is logged in for adding a book")
    public void the_user_is_logged_in_for_adding_a_book() {

        Response loginResponse = AuthService.login(
                UserCredentials.VALID.username(),
                UserCredentials.VALID.password()
        );

        assertEquals(200, loginResponse.getStatusCode());

        token = loginResponse.jsonPath().getString("token");
        userId = loginResponse.jsonPath().getString("userId");

        assertNotNull(token);
        assertNotNull(userId);
    }

    /**
     * Adds a book from the catalog to the user's collection.
     * Retrieves the first book from the catalog and sends a POST request with token.
     */
    @When("the user adds a book from the catalog to their collection")
    public void the_user_adds_a_book_from_the_catalog_to_their_collection() {

        Response booksResponse = RestAssured.get("/BookStore/v1/Books");
        isbn = booksResponse.jsonPath().getString("books[0].isbn");

        String addBody = """
            {
              "userId": "%s",
              "collectionOfIsbns": [
                { "isbn": "%s" }
              ]
            }
            """.formatted(userId, isbn);

        response = CommonRequest.send(
                "/BookStore/v1/Books",
                addBody,
                token
        );
    }

    /**
     * Checks that the book was added successfully.
     * Asserts that the server returned status 201 (Created).
     */
    @Then("the book should be added successfully")
    public void the_book_should_be_added_successfully() {
        assertEquals(201, response.getStatusCode());
    }
}

