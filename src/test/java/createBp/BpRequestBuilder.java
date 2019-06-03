package createBp;

import java.util.ArrayList;
import java.util.List;

public class BpRequestBuilder {
    Blood_pressures pressures;

    public BpRequestBuilder() {
        pressures = new Blood_pressures();
        pressures.setSystolic(120);
        pressures.setDiastolic(111);
        pressures.setUpdated_at("2019-04-10T05:34:44Z");
        pressures.setCreated_at("2019-04-10T05:34:44Z");
        pressures.setFacility_id("2f086ff7-83dc-4758-bd31-9d9109df9a09");
    }

    public BpRequestBuilder withSystolic(int value) {
        pressures.setSystolic(value);
        return this;
    }

    public BpRequestBuilder withDiastolic(int value) {
        pressures.setDiastolic(value);
        return this;
    }

    public BpRequestBuilder withUserId(String value) {
        pressures.setUser_id(value);
        return this;
    }

    public BpRequestBuilder withPatientId(String value) {
        pressures.setPatient_id(value);
        return this;
    }

    public BpRequestBuilder withBpId(String value) {
        pressures.setId(value);
        return this;
    }

    public BpRequestBuilder withFacilityId(String value) {
        pressures.setFacility_id(value);
        return this;
    }

    public BpRequestBody build() {
        List<Blood_pressures> bp = new ArrayList<>();
        bp.add(pressures);
        return new BpRequestBody(bp);
    }
}
