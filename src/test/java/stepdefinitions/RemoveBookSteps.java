package stepdefinitions;

import api.AuthService;
import data.UserCredentials;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class RemoveBookSteps {

    private Response response;
    private String token;
    private String userId;

    @Given("the user is logged in for removing a book")
    public void the_user_is_logged_in_for_removing_a_book() {

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

    @When("the user removes a book from their collection")
    public void the_user_removes_a_book_from_their_collection() {

        Response booksResponse = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/BookStore/v1/Books?UserId=" + userId);

        String isbn = booksResponse.jsonPath().getString("books[0].isbn");
        assertNotNull(isbn);

        String deleteBody = """
            {
              "userId": "%s",
              "isbn": "%s"
            }
            """.formatted(userId, isbn);

        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(deleteBody)
                .delete("/BookStore/v1/Book");
    }

    @Then("the book should be removed successfully")
    public void the_book_should_be_removed_successfully() {
        assertEquals(204, response.getStatusCode());
    }
}
