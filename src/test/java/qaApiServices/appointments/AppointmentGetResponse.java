package qaApiServices.appointments;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AppointmentGetResponse {

    private List<Appointments> appointments;
    private String process_token;

    public AppointmentGetResponse(){}

    public AppointmentGetResponse(List<Appointments> appointments, String process_token) {
        this.appointments = appointments;
        this.process_token = process_token;
    }

    public int getCountOfScheduledAppointment(){
        List<Appointments> scheduled = appointments.stream().filter(element -> element.getStatus().equals("scheduled")).collect(Collectors.toList());
        return scheduled.size();
    }
}
