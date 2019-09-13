package qaApiServices.patients.request;

import lombok.Getter;
import lombok.Setter;
import qaApiServices.patients.builder.Patients;

import java.util.List;

@Getter
@Setter
public class PatientPostRequestBody {
    private List<Patients> patients;

    public PatientPostRequestBody(List<Patients> patients) {
        this.patients = patients;
    }
}
