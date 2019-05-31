package createPatients;

import java.util.List;

public class PatientRequestBody {
    private List<Patients> patients;

    public PatientRequestBody(List<Patients> patients) {
        this.patients = patients;
    }
}
