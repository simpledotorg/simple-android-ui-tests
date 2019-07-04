package protocolDrug;

import constants.QaApiUrl;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DrugClient {

    public ProtocolDrugResponse PostResquest(ProtocolDrugRequestBody requestBody,String userId,String facilityId,String token) {
        Response response = given()
                .contentType("application/json; charset=utf-8")
                .header("Content-Type", "application/json")
                .header("X-User-Id", userId)
                .header("X-Facility-Id", facilityId)
                .header("Authorization", "Bearer "+token)
                .body(requestBody)
                .post(QaApiUrl.getPrescriptionDrug);

        System.out.println(response.asString()+"response String");
        System.out.println(response.statusCode()+"statuscode");

        ProtocolDrugResponse protocolDrugResponse = response.as(ProtocolDrugResponse.class);
        return protocolDrugResponse;
    }
}
