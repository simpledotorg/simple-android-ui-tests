package qaApiServices.patients;

import com.google.gson.Gson;
import constants.QaApiUrl;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class PatientClient {
    public PatientPostRequestResponse post(PatientPostRequestBody requestBody, String faciltiyId, String userId, String token) {

        String json = new Gson().toJson(requestBody);

        Response response = given()
                .contentType("application/json; charset=utf-8")
                .header("Accept", "application/json")
                .header("X-User-Id", userId)
                .header("X-Facility-Id", faciltiyId)
                .header("Authorization", "Bearer " + token)
                .body(json)
                .post(QaApiUrl.patient);

        System.out.println(response.asString() + "response");

        Assert.assertTrue(response.statusCode() == 200, "create Patient api service failed");
        return response.as(PatientPostRequestResponse.class);
    }


    public PatientGetRequestResponse get(String facilityId, String userId, String token) {

        Response response = given()
                .contentType("application/json; charset=utf-8")
                .queryParam("limit",15)
                .header("Content-Type", "application/json")
                .header("X-User-Id", userId)
                .header("X-Facility-Id", facilityId)
                .header("Authorization", "Bearer " +token)
                .get(QaApiUrl.patient);

        System.out.println(response.asString() + "response");

        Assert.assertTrue(response.statusCode() == 200, "get all Patient -api service failed");
        return response.as(PatientGetRequestResponse.class);
    }
}
