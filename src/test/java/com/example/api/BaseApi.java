package com.example.api;

import io.restassured.RestAssured;

/**
 * Base API class for setting up REST Assured.
 * Sets the base URL for all API requests to the DemoQA Book Store app.
 *
 * This ensures that all REST Assured calls use the correct API endpoint.
 */
public class BaseApi {

    static {
        RestAssured.baseURI = "https://demoqa.com";
    }
}

