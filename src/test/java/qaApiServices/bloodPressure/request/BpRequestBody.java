package qaApiServices.bloodPressure.request;

import lombok.Getter;
import lombok.Setter;
import qaApiServices.bloodPressure.builder.Blood_pressures;

import java.util.List;

@Getter
@Setter
public class BpRequestBody {
    private List<Blood_pressures> blood_pressures;

    public BpRequestBody(List<Blood_pressures> blood_pressures) {
        this.blood_pressures = blood_pressures;
    }
}
