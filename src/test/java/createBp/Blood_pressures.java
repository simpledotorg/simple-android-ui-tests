package createBp;

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

}
