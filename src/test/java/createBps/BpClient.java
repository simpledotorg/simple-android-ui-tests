package createBps;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BpClient {
    public BpResponse createNewBp(String bpId, String patientId, String faciltiyId, String userId, String token) {

        List<Blood_pressures> blood_pressures= new ArrayList<>();
        blood_pressures.add(new Blood_pressures(211,120,"2019-04-10T05:34:44Z","2019-04-10T05:34:44Z",userId,patientId,faciltiyId,bpId));
        BpRequestBody bpRequestBody=new BpRequestBody(blood_pressures);

        String json = new Gson().toJson(bpRequestBody);

        Response response = given()
                .contentType("application/json; charset=utf-8")
                .header("Content-Type", "application/json")
                .header("X-User-Id", userId)
                .header("X-Facility-Id", faciltiyId)
                .header("Authorization", "Bearer "+token)
                .body(json)
                .post("https://api-qa.simple.org/api/v3/blood_pressures/sync");

        System.out.println("bpResponse"+response.asString());

        BpResponse bpResponse = response.as(BpResponse.class);
        return bpResponse;
    }

}
