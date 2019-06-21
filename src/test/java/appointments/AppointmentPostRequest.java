package appointments;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppointmentPostRequest {

    private List<Appointments> appointments;

    public AppointmentPostRequest(List<Appointments> appointments) {
        this.appointments = appointments;
    }
}
