package qaApiServices.appointments;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AppointmentTest {

    @org.testng.annotations.Test
    public void createAppointmentTest() {

        String userId ="17D16dD4-6CAd-DeB5-bBDd-D4a5dBb20ff3";
        String facilityId ="2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String token ="da31d491095e2f442819c46a9e0f76402a3c86374056745b59088eabc5420bc0";
        String patientId="DB86fE3b-c0D4-5DeB-be4F-73EDE5A93b62";


        Appointments appointmentRequest = new Appointments.Builder().withFacilityId(facilityId)
                .withPatientId(patientId).build();
        List<Appointments> lst = new ArrayList<>();
        lst.add(appointmentRequest);

        AppointmentPostRequest request= new AppointmentPostRequest(lst);

        new ClientRequest().POST(request, facilityId, userId, token);
    }

    @org.testng.annotations.Test
    public void getAllAppointments() {

        String userId ="17D16dD4-6CAd-DeB5-bBDd-D4a5dBb20ff3";
        String facilityId ="2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String token ="da31d491095e2f442819c46a9e0f76402a3c86374056745b59088eabc5420bc0";

        AppointmentGetResponse getResponse = new ClientRequest().GET(facilityId, userId, token);
        System.out.println(getResponse.getAppointments().size()+"number of appointment");
    }

    @org.testng.annotations.Test
    public void getScheduleAppointmentsCount(){
        String userId ="6AC93eeD-dD77-aFFb-EFfe-f275F5Fdf2EF";
        String facilityId ="2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String token ="da01c9aa05c9b99700848f4050818f54795d359a7c5fc3e55e89b989ac28776f";

        AppointmentGetResponse getResponse = new ClientRequest().GET(facilityId, userId, token);
        int countOfScheduledAppointment = getResponse.getCountOfScheduledAppointment();
        System.out.println(countOfScheduledAppointment);
    }
}
