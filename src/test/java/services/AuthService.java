package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthService {

    private static String token;
    private static String userId;

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

    // Getters
    public static String getToken() {
        if (token == null) login("walton.goggins", "A9b!X@r2");
        return token;
    }

    public static String getUserId() {
        if (userId == null) login("walton.goggins", "A9b!X@r2");
        return userId;
    }
}
