package qaApiServices.protocolDrug;

import com.embibe.optimus.utils.ScenarioContext;
import org.testng.annotations.Test;
import utils.ScenarioContextKeys;

import java.util.ArrayList;
import java.util.List;

public class CreateDrug {

    @Test
    public void check() {
        String useRId="8b8c3eBb-52F6-3efC-ad3C-9fe1BadE956D";
        String patientId="Bd59CE6B-4C4D-A6ad-ce73-d81fbBBeef1C";
        String facility="2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String token="75ab085cc52632446f87295d7d6dca08af45f3feed4c483f476274fdec21fe16";
        Prescription_drugs prescription_drugs = new Prescription_drugs.Builder().withPatientId(patientId).withFacilityId(facility).build();

        List<Prescription_drugs> lst=new ArrayList<>();
        lst.add(prescription_drugs);

        ProtocolDrugRequestBody protocolDrugRequestBody= new ProtocolDrugRequestBody(lst);
        ProtocolDrugResponse protocolDrugResponse = new DrugClient().PostResquest(protocolDrugRequestBody,useRId,facility,token);
    }


    public void createProtocolDrugFromAPI(){
        String userId=ScenarioContext.getData("User",ScenarioContextKeys.USER_ID);
        String patientId=ScenarioContext.getData("User",ScenarioContextKeys.PATIENT_ID);
        String facility=ScenarioContext.getData("User",ScenarioContextKeys.FACILTIYID);
        String token=ScenarioContext.getData("User",ScenarioContextKeys.ACCESS_TOKEN);

        System.out.println(userId+" "+patientId+"   fac:"+facility+" "+token+"values");

        Prescription_drugs prescription_drugs = new Prescription_drugs.Builder().withPatientId(patientId).withFacilityId(facility).build();

        List<Prescription_drugs> lst=new ArrayList<>();
        lst.add(prescription_drugs);

        ProtocolDrugRequestBody protocolDrugRequestBody= new ProtocolDrugRequestBody(lst);
         new DrugClient().PostResquest(protocolDrugRequestBody,userId,facility,token);
    }
}
