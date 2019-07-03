package appointments;

import com.embibe.optimus.utils.ScenarioContext;
import utils.Date;
import utils.ScenarioContextKeys;

import java.util.ArrayList;
import java.util.List;

public class CreateAppointment {

    //this method is used to create appointment with current date
    //by default appointment would be set for +30 days
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

    //this method is used to create appointment with any given schedule date.
    //method used to create an overdue appointment with today's date scenario
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


   //this method is used to create overdue appointment
   public void createAppointmentForOverduePatient(int dd){
       String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
       String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
       String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);
       String patientId = ScenarioContext.getData("User", ScenarioContextKeys.PATIENT_ID);


       Appointments appointmentRequest = new Appointments.Builder()
               .withFacilityId(facilityId)
               .withPatientId(patientId)
               .withUpdatedAt(Date.getBackDateIn_RFC339_Format(dd))
               .withCreatedAt(Date.getBackDateIn_RFC339_Format(dd))
               .withScheduled_date(Date.appointmentScheduleDate(dd)).build();
       List<Appointments> lst = new ArrayList<>();
       lst.add(appointmentRequest);

       AppointmentPostRequest request= new AppointmentPostRequest(lst);

       new ClientRequest().POST(request, facilityId, userId, token);
   }


}
