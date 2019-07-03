package patients;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientPostRequestBody {
    private List<Patients> patients;

    public PatientPostRequestBody(List<Patients> patients) {
        this.patients = patients;
    }
}
