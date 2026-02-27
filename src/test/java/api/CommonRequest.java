package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CommonRequest extends BaseApi {

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
