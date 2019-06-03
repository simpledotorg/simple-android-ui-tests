package createBp;

import com.google.gson.Gson;
import org.testng.annotations.Test;

public class test {

    @Test
    public void check() {
        String bpId = "94931459-f706-4a39-9755-754eb3fbd363";
        String patientId = "5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f27";
        String faciltiyId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String userId="5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f21";
        String token = "b4c38ab916c9259440906200c06b795a4a69380327735c837d0d2c55b0711577";
//        BpResponse response = new BpClient().createNewBp(bpId, patientId, faciltiyId, userId, token);

    }

    @Test
    public void test(){

        String bpId = "94931459-f706-4a39-9755-754eb3fbd363";
        String patientId = "5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f27";
        String userId="5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f21";
        String faciltiyId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String token = "b4c38ab916c9259440906200c06b795a4a69380327735c837d0d2c55b0711577";


        BpRequestBody buildi = new BpRequestBuilder().withSystolic(300)
                .withUserId(userId)
                .withBpId(bpId)
                .withPatientId(patientId).build();

        String s = new Gson().toJson(buildi);
        System.out.println(s);

        BpResponse response = new BpClient().createNewBp(buildi,faciltiyId,userId,token);
        System.out.println(response.toString());
    }
}
