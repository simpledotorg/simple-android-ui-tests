package CreateUser;

import helper.JsonHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public UserResponse registerNewUser(UserRequestBody requestBody) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://api-qa.simple.org/api/v3/users/register");

        System.out.println(response.asString());

        UserResponse userResponse = response.as(UserResponse.class);
        return userResponse;
    }
}
