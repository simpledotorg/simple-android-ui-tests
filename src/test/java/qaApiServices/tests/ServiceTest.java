package qaApiServices.tests;

import com.embibe.optimus.utils.ScenarioContext;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import qaApiServices.appointments.CreateAppointment;
import qaApiServices.bloodPressure.BpClient;
import qaApiServices.bloodPressure.CreateBp;
import qaApiServices.bloodPressure.builder.Blood_pressures;
import qaApiServices.bloodPressure.request.BpRequestBody;
import qaApiServices.patients.CreatePatients;
import qaApiServices.patients.PatientClient;
import qaApiServices.patients.builder.Address;
import qaApiServices.patients.builder.BusinessIdentifiers;
import qaApiServices.patients.builder.Patients;
import qaApiServices.patients.builder.Phone_numbers;
import qaApiServices.patients.request.PatientPostRequestBody;
import qaApiServices.patients.response.PatientPostRequestResponse;
import qaApiServices.user.RegisterUser;
import utils.Date;
import utils.ScenarioContextKeys;

import java.util.ArrayList;
import java.util.List;

public class ServiceTest {

    //These methods can be used to create testdata while doing manual testing in QA

    private void createOverduePatientList(int count) {
        new RegisterUser().registerNewUser();
        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);
        Blood_pressures build = null;
        List<Blood_pressures> bp = new ArrayList<>();

        while (count > 0) {
//            int dd = new Faker().random().nextInt(40, 90);
            int dd = new Faker().random().nextInt(40, 90);
            new CreatePatients().createPatientWithBackDate(dd);
            String patientId = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_ID);
            int i = 3;
            while (i > 0) {
                int dd1 = new Faker().random().nextInt(20, 90);

                build = new Blood_pressures.Builder()
                        .withUserId(userId)
                        .withPatientId(patientId)
                        .withCreatedAt(Date.getBackDateIn_RFC339_Format(dd1))
                        .withUpdatedAt(Date.getBackDateIn_RFC339_Format(dd1))
                        .withRecordedAt(Date.getBackDateIn_RFC339_Format(dd1))
                        .withFacilityId(facilityId).build();
                bp.add(build);
                i--;
            }
            BpRequestBody bpRequestBody = new BpRequestBody(bp);
            new BpClient().Post(bpRequestBody, facilityId, userId, token);

            new CreateAppointment().createAppointmentForOverduePatient(dd);
            count--;
        }
    }

    @Test
    public void getOverduePatientList() {
        createOverduePatientList(1);
    }


    @Test
    public void getPatientlist() {
        new RegisterUser().registerNewUser();
        createPatientList(1);
    }

    private void createPatientList(int count) {
        while (count > 0) {
            new CreatePatients().createPatient();
            new CreateBp().registerNewBp();
            new CreateAppointment().createAppointment();
            count--;
        }
    }

    @Test
    public void createPatientWithBpPassport() {
        new RegisterUser().registerNewUser();
        List<Phone_numbers> ph = new ArrayList<>();
        Phone_numbers phone_number = new Phone_numbers.Builder()
                .withPhoneType("mobile").Build();
        ph.add(phone_number);

        Address address = new Address.Builder().Build();

        List<BusinessIdentifiers> bi = new ArrayList<>();
        BusinessIdentifiers businessIdentifiers = new BusinessIdentifiers.Builder().build();
        bi.add(businessIdentifiers);

        Patients build = new Patients.Builder().withAddress(address).withAge(44).withGender("male").withPhoneNumber(ph).withStatus("active")
                .withBusinessIdentifier(bi)
                .build();

        List<Patients> patients = new ArrayList<>();
        patients.add(build);

        PatientPostRequestBody patientRequestBody = new PatientPostRequestBody(patients);


        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);

        PatientPostRequestResponse response = new PatientClient().post(patientRequestBody, facilityId, userId, token);
        System.out.println(response.toString());
    }
}
