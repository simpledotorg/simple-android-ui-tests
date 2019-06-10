package createPatients;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class test {

    @Test
    public void getPatientResponse() {
        String patientId = "5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f29";
        String facilityId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String userId = "1Ef2a7AC-6FBf-005D-90FA-3Ed4dFD3fbBe";
        String token = "7ab3e0522c536bfa6b590cf6dc555a840e59c7f91cf65ece87ca5637165f5e63";

        List<Phone_numbers> ph = new ArrayList<>();
        Phone_numbers phone_number = new Phone_numbers.Builder()
                .withPhoneType("mobile").Build();
        ph.add(phone_number);
        Address address = new Address.Builder().Build();

        Patients build = new Patients.Builder().withAddress(address).withAge(44).withGender("male").withPhoneNumber(ph).withStatus("active").build();
        Patients build1 = new Patients.Builder().withAddress(address).withAge(44).withGender("male").withPhoneNumber(ph).withStatus("active").build();

        List<Patients> patients = new ArrayList<>();
        patients.add(build);
        patients.add(build1);

        PatientRequestBody patientRequestBody = new PatientRequestBody(patients);

        PatientResponse response = new PatientClient().createPatient(patientRequestBody, facilityId, userId, token);
        System.out.println(response.toString());

    }
}
