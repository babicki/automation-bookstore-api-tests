package com.example.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Service class for login operations.
 * Stores authentication token and user ID to avoid logging in many times.
 *
 * Static methods provide easy access to the token and user ID.
 * If data is not available, it will login automatically.
 */
public class AuthService {

    private static String token;
    private static String userId;

    /**
     * Logs in a user and saves the token and user ID.
     * Makes a direct API call to the login endpoint.
     *
     * Example:
     * AuthService.login("walton.goggins", "A9b!X@r2");
     * String token = AuthService.getToken();
     */
    public static void login(String username, String password) {
        String requestBody = """
            {
              "userName": "%s",
              "password": "%s"
            }
        """.formatted(username, password);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://demoqa.com/Account/v1/Login");

        token = response.jsonPath().getString("token");
        userId = response.jsonPath().getString("userId");
    }

    /**
     * Returns the saved authentication token.
     * If no token is saved, logs in automatically with default credentials.
     */
    public static String getToken() {
        if (token == null) login("walton.goggins", "A9b!X@r2");
        return token;
    }

    /**
     * Returns the saved user ID.
     * If no user ID is saved, logs in automatically with default credentials.
     */
    public static String getUserId() {
        if (userId == null) login("walton.goggins", "A9b!X@r2");
        return userId;
    }
}

