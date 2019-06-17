package protocolDrug;


import com.embibe.optimus.utils.ScenarioContext;
import lombok.Getter;
import lombok.Setter;
import utils.RandomValue;
import utils.ScenarioContextKeys;

@Getter
@Setter
public class Prescription_drugs {

    private String dosage;
    private Boolean is_deleted;
    private String updated_at;
    private String rxnorm_code;
    private String patient_id;
    private String name;
    private String created_at;
    private Boolean is_protocol_drug;
    private String facility_id;
    private String id;

    public Prescription_drugs(String dosage, Boolean is_deleted, String updated_at, String rxnorm_code, String patient_id, String name, String created_at, Boolean is_protocol_drug, String facility_id, String id) {
        this.dosage = dosage;
        this.is_deleted = is_deleted;
        this.updated_at = updated_at;
        this.rxnorm_code = rxnorm_code;
        this.patient_id = patient_id;
        this.name = name;
        this.created_at = created_at;
        this.is_protocol_drug = is_protocol_drug;
        this.facility_id = facility_id;
        this.id = id;
    }

    public static class Builder {

        private String dosage="10 mg";
        private Boolean is_deleted=false;
        private String updated_at="2019-06-17T05:34:44Z";
        private String rxnorm_code="testdrugcode";
        private String patient_id;
        private String name="testAutomationDrug2";
        private String created_at="2019-06-17T05:34:44Z";
        private Boolean is_protocol_drug=true;
        private String facility_id;
        private String id=RandomValue.getRandomProtocolId();

        public Builder() {
        }

        public Builder withPatientId(String patientId){
            this.patient_id=patientId;
            return this;
        }

        public Builder withFacilityId(String facilityId){
            this.facility_id=facilityId;
            return this;
        }

        public Prescription_drugs build(){
            ScenarioContext.putData("User",ScenarioContextKeys.DRUG_NAME,name);
            String drugInfo=dosage+"   "+name;
            ScenarioContext.putData("User",ScenarioContextKeys.DRUG_INFO,drugInfo);
            return  new Prescription_drugs(dosage, is_deleted, updated_at, rxnorm_code, patient_id, name, created_at, is_protocol_drug, facility_id,id);
        }
    }
}
