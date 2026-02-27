package api;

import io.restassured.response.Response;

public class AuthService {

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
