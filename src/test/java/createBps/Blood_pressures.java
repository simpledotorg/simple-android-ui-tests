package createBps;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Blood_pressures {
    private int systolic;
    private int diastolic;
    private String updated_at;
    private String user_id;
    private String patient_id;
    private String created_at;
    private String facility_id;
    private String id;

    public Blood_pressures(int systolic, int diastolic, String updated_at, String created_at, String user_id, String patient_id, String facility_id, String id) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.updated_at = updated_at;
        this.user_id = user_id;
        this.patient_id = patient_id;
        this.created_at = created_at;
        this.facility_id = facility_id;
        this.id = id;
    }
}
