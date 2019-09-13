package qaApiServices.user ;

import constants.QaApiUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import qaApiServices.user.request.UserPostRequest;
import qaApiServices.user.response.UserResponse;

import static io.restassured.RestAssured.given;

public class UserClient {

    public UserResponse registerNewUser(UserPostRequest requestBody) {

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(QaApiUrl.registerUser);

        Assert.assertTrue(response.statusCode()==200,"User api service failed");
        UserResponse userResponse =response.as(UserResponse.class);
        return userResponse;
    }
}
