package qaApiServices.bloodPressure;

import com.embibe.optimus.utils.ScenarioContext;
import utils.Date;
import utils.ScenarioContextKeys;

import java.util.ArrayList;
import java.util.List;

public class CreateBp {

    public void registerNewBp(){
        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);
        String patientId=ScenarioContext.getData("User",ScenarioContextKeys.PATIENT_ID);

        Blood_pressures build = new Blood_pressures.Builder()
                .withUserId(userId)
                .withPatientId(patientId)
                .withFacilityId(facilityId).build();

        List<Blood_pressures> bp = new ArrayList<>();
        bp.add(build);
        BpRequestBody bpRequestBody = new BpRequestBody(bp);

        new BpClient().Post(bpRequestBody,facilityId,userId,token);
    }

    public void createBpList( String id, int count){
        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);
        String patientId=id;
        List<Blood_pressures> bp = new ArrayList<>();

        while(count>0){
            Blood_pressures build = new Blood_pressures.Builder()
                    .withUserId(userId)
                    .withPatientId(patientId)
                    .withFacilityId(facilityId).build();
            bp.add(build);
            count--;
        }

        BpRequestBody bpRequestBody = new BpRequestBody(bp);

        new BpClient().Post(bpRequestBody,facilityId,userId,token);
    }

    public void createBpWithBackDate(int dd){
        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);
        String token = ScenarioContext.getData("User", ScenarioContextKeys.ACCESS_TOKEN);
        String patientId=ScenarioContext.getData("User",ScenarioContextKeys.PATIENT_ID);

        Blood_pressures build = new Blood_pressures.Builder()
                .withUserId(userId)
                .withPatientId(patientId)
                .withCreatedAt(Date.getBackDateIn_RFC339_Format(dd))
                .withUpdatedAt(Date.getBackDateIn_RFC339_Format(dd))
                .withFacilityId(facilityId).build();

        List<Blood_pressures> bp = new ArrayList<>();
        bp.add(build);
        BpRequestBody bpRequestBody = new BpRequestBody(bp);

        new BpClient().Post(bpRequestBody,facilityId,userId,token);
    }
}
