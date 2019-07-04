package qaApiServices.user ;

import constants.QaApiUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class UserClient {

    public UserResponse registerNewUser(UserPostRequest requestBody) {

        System.out.println(requestBody+"requestbody");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(QaApiUrl.registerUser);

        System.out.println(response.asString()+"User response");

        Assert.assertTrue(response.statusCode()==200,"User api service failed");

        UserResponse userResponse =response.as(UserResponse.class);
        return userResponse;
    }
}
