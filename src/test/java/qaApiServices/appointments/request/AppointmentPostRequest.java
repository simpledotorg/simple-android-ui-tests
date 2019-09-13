package qaApiServices.appointments.request;

import lombok.Getter;
import lombok.Setter;
import qaApiServices.appointments.builder.Appointments;

import java.util.List;

@Getter
@Setter
public class AppointmentPostRequest {

    private List<Appointments> appointments;

    public AppointmentPostRequest(List<Appointments> appointments) {
        this.appointments = appointments;
    }
}
