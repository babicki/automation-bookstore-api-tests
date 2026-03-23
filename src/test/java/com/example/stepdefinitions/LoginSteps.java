package com.example.stepdefinitions;

import com.example.api.AuthService;
import com.example.data.UserCredentials;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static org.junit.Assert.*;

/**
 * Step definitions for user login tests.
 * Handles login scenarios and checks authentication token retrieval.
 */
public class LoginSteps {

    private Response response;
    private String token;

    /**
     * Sends a valid login request using test credentials.
     * Extracts the authentication token for later use.
     */
    @Given("the user sends a valid login request")
    public void the_user_sends_a_valid_login_request() {

        response = AuthService.login(
                UserCredentials.VALID.username(),
                UserCredentials.VALID.password()
        );

        token = response.jsonPath().getString("token");
    }

    /**
     * Checks that the login response status is 200 (OK).
     * Confirms successful authentication.
     */
    @Then("the response status code should be 200")
    public void the_response_status_code_should_be_200() {
        assertEquals(200, response.getStatusCode());
    }

    /**
     * Verifies that the response contains a valid authentication token.
     * Token must be non-null and not empty.
     */
    @Then("the response should contain an authentication token")
    public void the_response_should_contain_an_authentication_token() {
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }
}

