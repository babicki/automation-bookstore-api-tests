package stepdefinitions;

import api.AuthService;
import data.UserCredentials;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class LoginSteps {

    private Response response;
    private String token;

    @Given("the user sends a valid login request")
    public void the_user_sends_a_valid_login_request() {

        response = AuthService.login(
                UserCredentials.VALID.username(),
                UserCredentials.VALID.password()
        );

        token = response.jsonPath().getString("token");
    }

    @Then("the response status code should be 200")
    public void the_response_status_code_should_be_200() {
        assertEquals(200, response.getStatusCode());
    }

    @Then("the response should contain an authentication token")
    public void the_response_should_contain_an_authentication_token() {
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }
}
