package createPatients;

import com.embibe.optimus.utils.ScenarioContext;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.ScenarioContextKeys;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PatientClient {
    public PatientResponse createPatient(String patientId,String patientName, String faciltiyId, String userId, String token) {

        List<Phone_numbers> phone_numbers= new ArrayList<>();
        phone_numbers.add(new Phone_numbers("1234567","mobile","2019-05-29T05:39:35Z",true,"2019-05-29T05:39:35Z","5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f40",""));
        Address address = new Address("test","India","123456","2019-05-29T05:39:35Z","Satara","2019-05-29T05:39:35Z","5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f40","Punjab","","testVillage");

        List<Patients> patients= new ArrayList<>();
        patients.add(new Patients(phone_numbers,patientName,address,"male","2019-05-29T06:54:31Z","2000-05-29","2019-05-29T06:54:31Z",patientId,"",44,"2019-05-29T06:54:31Z","active"));

        PatientRequestBody requestBody= new PatientRequestBody(patients);
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
        System.out.println(response.asString());

        PatientResponse patientResponse = response.as(PatientResponse.class);
        return patientResponse;

    }

}
