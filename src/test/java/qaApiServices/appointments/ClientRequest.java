package qaApiServices.appointments;

import com.google.gson.Gson;
import constants.QaApiUrl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class ClientRequest {

    public AppointmentPostResponse POST(AppointmentPostRequest appointmentRequest, String facilityId, String userId, String token) {
        String json = new Gson().toJson(appointmentRequest);

        Response response = given()
                .contentType("application/json; charset=utf-8")
                .header("Content-Type", "application/json")
                .header("X-User-Id", userId)
                .header("X-Facility-Id", facilityId)
                .header("Authorization", "Bearer " + token)
                .body(json)
                .post(QaApiUrl.Appointment);

        System.out.println("appointment Response" + response.asString());

        Assert.assertTrue(response.statusCode() == 200, "create appointment api service failed");

        AppointmentPostResponse appointmentResponse = response.as(AppointmentPostResponse.class);
        return appointmentResponse;
    }


    public AppointmentGetResponse GET(String facilityId, String userId, String token) {
        RequestSpecification authorization = given()
                .contentType("application/json; charset=utf-8")
                .header("Content-Type", "application/json")
                .header("X-User-Id", userId.toLowerCase())
                .header("X-Facility-Id", facilityId)
                .header("Authorization", "Bearer " + token);

        Response response = authorization.get(QaApiUrl.Appointment);
        System.out.println(response.then().log().everything());
        System.out.println("appointment Response" + response.asString());

        Assert.assertTrue(response.statusCode() == 200, "get appointment api service failed");

        AppointmentGetResponse appointmentResponse = response.as(AppointmentGetResponse.class);
        return appointmentResponse;
    }
}

