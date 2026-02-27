package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static org.junit.Assert.assertTrue;

public class AddBookToCatalogSteps {

    private Response response;

    @When("the user tries to add a new book to the global catalog")
    public void the_user_tries_to_add_a_new_book_to_the_global_catalog() {

        String requestBody = """
            {
              "isbn": "1234567890",
              "title": "Nieistniejąca książka",
              "subTitle": "Demo",
              "author": "Test Author",
              "publish_date": "2026-01-10T00:00:00.000Z",
              "publisher": "Demo Publisher",
              "pages": 100,
              "description": "Testowa książka do globalnego katalogu",
              "website": "https://example.com"
            }
        """;

        RestAssured.baseURI = "https://demoqa.com";

        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/BookStore/v1/Books");

        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("Status code: " + response.getStatusCode());
    }

    @Then("the API should reject the request")
    public void the_api_should_reject_the_request() {

        assertTrue("API should reject adding a new book to global catalog",
                response.getStatusCode() != 201);
    }
}
