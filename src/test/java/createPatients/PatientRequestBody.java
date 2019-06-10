package createPatients;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientRequestBody {
    private List<Patients> patients;

    public PatientRequestBody(List<Patients> patients) {
        this.patients = patients;
    }
}
