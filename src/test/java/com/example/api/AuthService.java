package com.example.api;

import io.restassured.response.Response;

/**
 * Auth service for login operations.
 * Provides methods to login and get authentication tokens.
 * Uses CommonRequest to send actual HTTP requests.
 */
public class AuthService {

    /**
     * Sends a login request with given username and password.
     * Returns the response with token and userId.
     *
     * Example:
     * Response response = AuthService.login("walton.goggins", "A9b!X@r2");
     * String token = response.jsonPath().getString("token");
     */
    public static Response login(String username, String password) {

        String body = """
            {
              "userName": "%s",
              "password": "%s"
            }
            """.formatted(username, password);

        return CommonRequest.send(
                "/Account/v1/Login",
                body,
                null
        );
    }
}

