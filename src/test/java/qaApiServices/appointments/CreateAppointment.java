package qaApiServices.appointments;

import com.embibe.optimus.utils.ScenarioContext;
import qaApiServices.appointments.builder.AppointmentGetResponse;
import qaApiServices.appointments.builder.Appointments;
import qaApiServices.appointments.request.AppointmentPostRequest;
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
               .withScheduled_date(Date.scheduleAppointmentWithBackDate(dd)).build();
       List<Appointments> lst = new ArrayList<>();
       lst.add(appointmentRequest);

       AppointmentPostRequest request= new AppointmentPostRequest(lst);

       new ClientRequest().POST(request, facilityId, userId, token);
   }

   public int getAllScheduledAppointment(){
       String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
       String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
       String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);

       AppointmentGetResponse repsonse = new ClientRequest().GET(facilityId, userId, token);
       System.out.println(repsonse.toString());

       return repsonse.getCountOfScheduledAppointment();
   }
}
