package qaApiServices.bloodPressure.response;

import lombok.Getter;
import lombok.Setter;
import qaApiServices.bloodPressure.builder.Blood_pressures;

import java.util.List;

@Getter
@Setter
public class BpGetRequestResponse {
    private List<Blood_pressures> blood_pressures;
    private String process_token;


}
