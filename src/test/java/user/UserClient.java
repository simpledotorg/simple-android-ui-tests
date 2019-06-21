package user;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class UserClient {

    public UserResponse registerNewUser(UserRequestBody requestBody) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://api-qa.simple.org/api/v3/users/register");

        System.out.println(response.asString()+"User response");

        Assert.assertTrue(response.statusCode()==200,"User api service failed");

        UserResponse userResponse = response.as(UserResponse.class);
        return userResponse;
    }
}
