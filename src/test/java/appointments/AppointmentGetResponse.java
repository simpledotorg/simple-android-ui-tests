package appointments;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
}
