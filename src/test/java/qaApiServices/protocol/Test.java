package qaApiServices.protocol;

import qaApiServices.protocol.response.ProtocolResponse;

import java.util.HashSet;

public class Test {

    @org.testng.annotations.Test
    public void getProtocolDrugList(){

        ProtocolClient protocolClient= new ProtocolClient();
        ProtocolResponse protocolResponse = protocolClient.getAllProtocolInfo();

        HashSet<String> protocolDrugNameList = protocolResponse.getProtocolDrugNameList("426f4364-6d5a-41cc-a9a4-49ef1fea161a");
        System.out.println(protocolDrugNameList);

    }
}
