package com.example.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Utility class for sending HTTP requests.
 * Handles request setup with JSON content type and optional Bearer token.
 *
 * All requests use the base URL from BaseApi.
 */
public class CommonRequest extends BaseApi {

    /**
     * Sends a POST request to the given endpoint.
     * Supports optional Bearer token for authentication.
     *
     * Example:
     * Response response = CommonRequest.send(
     *     "/BookStore/v1/Books",
     *     requestBody,
     *     "auth-token-here"
     * );
     */
    public static Response send(String endpoint, Object body, String token) {

        RequestSpecification request = given()
                .contentType(ContentType.JSON)
                .body(body);

        if (token != null) {
            request.header("Authorization", "Bearer " + token);
        }

        return request.post(endpoint);
    }
}

