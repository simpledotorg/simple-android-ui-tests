package qaApiServices.facility;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Test {

    @org.testng.annotations.Test
    public void getAllFacilityInfo() {

        FacilityClient facilityClient = new FacilityClient();
        FacilityResponse allFacilityInfo = facilityClient.getAllFacilityInfo();
        String protocolId = allFacilityInfo.getProtocolId("2f086ff7-83dc-4758-bd31-9d9109df9a09");
        System.out.println(protocolId);
    }


    @org.testng.annotations.Test
    public void check(){
        List<String> ls= new ArrayList<>();
        ls.add("Today");
        ls.add("5 mg   Amlodipine");

        List<String> ls2= new ArrayList<>();
        ls2.add("Today");
        ls2.add("5 mg   Amlodipine");


        Assert.assertTrue(ls.containsAll(ls2));
    }
}
