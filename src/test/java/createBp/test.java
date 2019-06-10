package createBp;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class test {

    @Test
    public void test() {

        String bpId = "94931459-f706-4a39-9755-754eb3fbd363";
        String patientId = "5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f27";
        String userId = "5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f21";
        String faciltiyId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String token = "b4c38ab916c9259440906200c06b795a4a69380327735c837d0d2c55b0711577";


        Blood_pressures build = new Blood_pressures.Builder().withSystolic(300)
                .withUserId(userId)
                .withBpId(bpId)
                .withPatientId(patientId)
                .withFacilityId(faciltiyId).build();
        Blood_pressures build2 = new Blood_pressures.Builder().withSystolic(300)
                .withUserId(userId)
                .withBpId(bpId)
                .withPatientId(patientId)
                .withFacilityId(faciltiyId).build();

        List<Blood_pressures> bp = new ArrayList<>();
        bp.add(build);
        bp.add(build2);

        BpRequestBody bpRequestBody = new BpRequestBody(bp);

        String s = new Gson().toJson(bpRequestBody);
        System.out.println(s);

        BpResponse response = new BpClient().createNewBp(bpRequestBody,faciltiyId,userId,token);
        System.out.println(response.toString());
    }
}
