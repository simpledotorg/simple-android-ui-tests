package patients;

import com.embibe.optimus.utils.ScenarioContext;
import utils.Date;
import utils.ScenarioContextKeys;

import java.util.ArrayList;
import java.util.List;

public class CreatePatients {

    //    this is to create patient with phonenumber
    public void createPatient() {

        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);

        List<Phone_numbers> ph = new ArrayList<>();
        Phone_numbers phone_number = new Phone_numbers.Builder()
                .withPhoneType("mobile").Build();
        ph.add(phone_number);
        Address address = new Address.Builder().Build();

        Patients build = new Patients.Builder().withAddress(address).withAge(44).withGender("male").withPhoneNumber(ph).withStatus("active").build();

        List<Patients> patients = new ArrayList<>();
        patients.add(build);
        PatientPostRequestBody patientRequestBody = new PatientPostRequestBody(patients);


        new PatientClient().post(patientRequestBody, facilityId, userId, token);
    }

    public void createPatientWithoutPhoneNumber() {

        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);

        Address address = new Address.Builder().Build();

        Patients build = new Patients.Builder().withAddress(address).withAge(44).withGender("male").withStatus("active").build();

        List<Patients> patients = new ArrayList<>();
        patients.add(build);
        PatientPostRequestBody patientRequestBody = new PatientPostRequestBody(patients);

        new PatientClient().post(patientRequestBody, facilityId, userId, token);
    }

    public PatientGetRequestResponse getAllPatient() {

        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);

        return new PatientClient().get(facilityId, userId, token);
    }

    public void createPatientWithBackDate(int dd) {
        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);

        List<Phone_numbers> ph = new ArrayList<>();
        Phone_numbers phone_number = new Phone_numbers.Builder()
                .withPhoneType("mobile").Build();
        ph.add(phone_number);
        Address address = new Address.Builder().Build();

        Patients build = new Patients.Builder()
                .withCreatedAt(Date.getBackDateIn_RFC339_Format(dd))
                .withUpdatedAt(Date.getBackDateIn_RFC339_Format(dd))
                .withAddress(address).withAge(44).withGender("male").withPhoneNumber(ph).withStatus("active").build();

        List<Patients> patients = new ArrayList<>();
        patients.add(build);
        PatientPostRequestBody patientRequestBody = new PatientPostRequestBody(patients);

        new PatientClient().post(patientRequestBody, facilityId, userId, token);
    }
}
