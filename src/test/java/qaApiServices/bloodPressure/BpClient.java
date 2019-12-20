package qaApiServices.bloodPressure;

import com.google.gson.Gson;
import constants.QaApiUrl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qaApiServices.bloodPressure.request.BpRequestBody;
import qaApiServices.bloodPressure.response.BpGetRequestResponse;
import qaApiServices.bloodPressure.response.BpResponse;

import static io.restassured.RestAssured.given;

public class BpClient {
    public BpResponse Post(BpRequestBody bpRequest, String facilityId, String userId, String token){
        String json = new Gson().toJson(bpRequest);

        RequestSpecification request = given()
                .contentType("application/json; charset=utf-8")
                .header("Content-Type", "application/json")
                .header("X-User-Id", userId)
                .header("X-Facility-Id", facilityId)
                .header("Authorization", "Bearer "+token)
                .body(json);

        System.out.println(request.log().everything());

        Response response=request.post(QaApiUrl.registerBp);

        System.out.println("bpResponse"+response.asString());

        BpResponse bpResponse = response.as(BpResponse.class);
        return bpResponse;
    }


    public BpGetRequestResponse Get(String facilityId, String userId, String token){

        Response response = given()
                .contentType("application/json; charset=utf-8")
                .header("Content-Type", "application/json")
                .header("X-User-Id", userId)
                .header("X-Facility-Id", facilityId)
                .header("Authorization", "Bearer "+token)
                .get(QaApiUrl.registerBp);

        System.out.println("getbpResponse"+response.asString());

        BpGetRequestResponse bpGetResponse = response.as(BpGetRequestResponse.class);
        return bpGetResponse;
    }
}
