package bloodPressure;

import com.google.gson.Gson;
import constants.QaApiUrl;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BpClient {
    public BpResponse Post(BpRequestBody bpRequest, String facilityId, String userId, String token){
        String json = new Gson().toJson(bpRequest);

        Response response = given()
                .contentType("application/json; charset=utf-8")
                .header("Content-Type", "application/json")
                .header("X-User-Id", userId)
                .header("X-Facility-Id", facilityId)
                .header("Authorization", "Bearer "+token)
                .body(json)
                .post(QaApiUrl.registerBp);

        System.out.println("bpResponse"+response.asString());

        BpResponse bpResponse = response.as(BpResponse.class);
        return bpResponse;
    }
}
