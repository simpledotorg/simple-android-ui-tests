package createPatients;

import org.testng.annotations.Test;

public class test {
    @Test
    public void check() {
        String patientId = "5fc3dbcb-7db6-4ae9-ac2e-62e9c8940f29";
        String facilityId = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String userId = "1Ef2a7AC-6FBf-005D-90FA-3Ed4dFD3fbBe";
        String token = "7ab3e0522c536bfa6b590cf6dc555a840e59c7f91cf65ece87ca5637165f5e63";
        String patientName="TestPatient";
        PatientResponse response = new PatientClient().createPatient(patientId,patientName,facilityId, userId, token);
        System.out.println(response.toString());

    }
}
