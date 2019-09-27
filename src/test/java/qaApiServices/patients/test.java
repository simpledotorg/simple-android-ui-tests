package qaApiServices.patients;

import org.testng.annotations.Test;
import qaApiServices.patients.builder.Address;
import qaApiServices.patients.builder.Patients;
import qaApiServices.patients.builder.Phone_numbers;
import qaApiServices.patients.response.PatientGetRequestResponse;
import qaApiServices.patients.request.PatientPostRequestBody;
import qaApiServices.patients.response.PatientPostRequestResponse;

import java.util.ArrayList;
import java.util.List;

public class test {

    @Test
    public void getPatientResponse() {
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

        PatientPostRequestBody patientRequestBody = new PatientPostRequestBody(patients);

        PatientPostRequestResponse response = new PatientClient().post(patientRequestBody, facilityId, userId, token);
        System.out.println(response.toString());

    }

    @Test
    public void getAllPatient() {

        String facilityId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String userId = "9eE7DF2d-2dAb-aFAb-aEee-BEd9bC15bB5d";
        String token = "7ca3bcf6427357640cef4f624744163529703b8aa14299394f6a0c269a22fdc3";

        PatientGetRequestResponse patientGetRequestResponse = new PatientClient().get(facilityId, userId, token);
        System.out.println(patientGetRequestResponse.toString());
        System.out.println(patientGetRequestResponse.getPatients().size());
    }

    @Test
    public void getAllPaientName(){
        String facilityId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String userId = "1AC82ddD-dD87-aEFa-EFfe-f272F1Fdf4EF";
        String token = "90a9743da70485b9d604ec873459dcc6af9323c780c598c846a56f5b4ecc3bb5";

        PatientGetRequestResponse patientGetRequestResponse = new PatientClient().get(facilityId, userId, token);
        patientGetRequestResponse.getAllPatientsName();
    }


}
