package qaApiServices.bloodPressure;

import com.google.gson.Gson;
import org.testng.annotations.Test;
import qaApiServices.bloodPressure.builder.Blood_pressures;
import qaApiServices.bloodPressure.request.BpRequestBody;
import qaApiServices.bloodPressure.response.BpResponse;

import java.util.ArrayList;
import java.util.List;

public class test {

    @Test
    public void bpList(){

        String patientId = "5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f27";
        String userId = "5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f21";
        String faciltiyId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String token = "b4c38ab916c9259440906200c06b795a4a69380327735c837d0d2c55b0711577";

        List<Blood_pressures> bp = new ArrayList<>();


        int count =2;
        while(count>0){
            Blood_pressures build = new Blood_pressures.Builder()
                    .withUserId(userId)
                    .withPatientId(patientId)
                    .withFacilityId(faciltiyId).build();
            bp.add(build);

            count--;
        }

        BpRequestBody bpRequestBody = new BpRequestBody(bp);
        String s = new Gson().toJson(bpRequestBody);
        System.out.println(s);

        BpResponse response = new BpClient().Post(bpRequestBody,faciltiyId,userId,token);
        System.out.println(response.toString());
    }
}
