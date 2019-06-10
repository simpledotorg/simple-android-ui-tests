package createPatients;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PatientClient {
    public PatientResponse createPatient(PatientRequestBody requestBody, String faciltiyId, String userId, String token) {

        String json = new Gson().toJson(requestBody);

        Response response = given()
                .contentType("application/json; charset=utf-8")
                .header("Accept","application/json")
                .header("X-User-Id", userId)
                .header("X-Facility-Id", faciltiyId)
                .header("Authorization", "Bearer "+token)
                .body(json)
                .post("https://api-qa.simple.org/api/v3/patients/sync");

        System.out.println("patient info generated");

        return response.as(PatientResponse.class);
    }

}
