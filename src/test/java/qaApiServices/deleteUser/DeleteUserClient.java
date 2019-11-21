package qaApiServices.deleteUser;

import constants.QaApiUrl;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class DeleteUserClient {

    public void deleteUser() {

        Response response = given()
                .contentType("application/json; charset=utf-8")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+ "3c1c6f4531e3b30c27389c6ac954ffe34c52ebdfebc469d115c386725b577946")
                .delete(QaApiUrl.delete);

        Assert.assertTrue(response.statusCode()==200,"Delete api service failed");
    }
}
