package bloodPressure;

import lombok.Getter;
import lombok.Setter;
import utils.RandomValue;

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

    public Blood_pressures(int systolic, int diastolic, String updated_at, String user_id, String patient_id, String created_at, String facility_id, String id) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.updated_at = updated_at;
        this.user_id = user_id;
        this.patient_id = patient_id;
        this.created_at = created_at;
        this.facility_id = facility_id;
        this.id = id;
    }

    public static class Builder {
        int systolic = 120;
        int diastolic = 111;
        String updated_at = "2019-06-12T05:34:44Z";
        String user_id;
        String patient_id;
        String created_at = "2019-06-12T05:34:44Z";
        String facility_id;
        String id=RandomValue.getRandomBpId();

        public Builder() {
        }

        public Builder withSystolic(int value) {
            this.systolic = value;
            return this;
        }

        public Builder withDiastolic(int value) {
            this.diastolic = value;
            return this;
        }

        public Builder withUserId(String value) {
            this.user_id = value;
            return this;
        }

        public Builder withPatientId(String value) {
            this.patient_id = value;
            return this;
        }

        public Builder withBpId(String value) {
            this.id = value;
            return this;
        }

        public Builder withFacilityId(String value) {
            this.facility_id = value;
            return this;
        }

        public Blood_pressures build() {
            return new Blood_pressures(systolic, diastolic, updated_at, user_id, patient_id, created_at, facility_id, id);
        }
    }
}
