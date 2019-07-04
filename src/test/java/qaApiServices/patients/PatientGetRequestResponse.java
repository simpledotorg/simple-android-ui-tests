package qaApiServices.patients;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PatientGetRequestResponse {
    private List<Patients> patients;
    private String process_token;
}
