package qaApiServices.facility;

import constants.QaApiUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FacilityClient {

    public FacilityResponse getAllFacilityInfo() {
        Response response = given()
                .contentType(ContentType.JSON)
                .get(QaApiUrl.getFacility);

//        System.out.println(response.asString());

        FacilityResponse facilityResponse = response.as(FacilityResponse.class);
        return facilityResponse;
    }
}
