package appointments;

import com.embibe.optimus.utils.ScenarioContext;
import utils.ScenarioContextKeys;

import java.util.ArrayList;
import java.util.List;

public class CreateAppointment {

    public void createAppointment() {

        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);
        String patientId = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_ID);


        Appointments appointmentRequest = new Appointments.Builder()
                                            .withFacilityId(facilityId)
                                            .withPatientId(patientId).build();
        List<Appointments> lst = new ArrayList<>();
        lst.add(appointmentRequest);

        AppointmentPostRequest request= new AppointmentPostRequest(lst);

        new ClientRequest().POST(request, facilityId, userId, token);
    }

    public void createAppointment(String date) {

        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);
        String patientId = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_ID);


        Appointments appointmentRequest = new Appointments.Builder()
                .withFacilityId(facilityId)
                .withPatientId(patientId)
                .withScheduled_date(date).build();
        List<Appointments> lst = new ArrayList<>();
        lst.add(appointmentRequest);

        AppointmentPostRequest request= new AppointmentPostRequest(lst);

        new ClientRequest().POST(request, facilityId, userId, token);
    }

}
