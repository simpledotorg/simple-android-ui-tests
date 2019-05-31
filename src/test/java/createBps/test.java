package createBps;

import org.testng.annotations.Test;

public class test {

    @Test
    public void check() {
        String bpId = "94931459-f706-4a39-9755-754eb3fbd363";
        String patientId = "5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f27";
        String faciltiyId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String userId="5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f21";
        String token = "b4c38ab916c9259440906200c06b795a4a69380327735c837d0d2c55b0711577";
        BpResponse response = new BpClient().createNewBp(bpId, patientId, faciltiyId, userId, token);
    }
}
