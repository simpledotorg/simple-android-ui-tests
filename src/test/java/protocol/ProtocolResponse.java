package protocol;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProtocolResponse {
    private List<Protocols> protocols;

    private String process_token;

    public HashSet<String> getProtocolDrugNameList(String protocolId){
        Protocol_drugs[] protocol_drugs = protocols.stream().filter(t -> t.getId().equals(protocolId)).collect(Collectors.toList()).get(0).getProtocol_drugs();

        HashSet<String> uniqueValues= new HashSet<>();
        for ( Protocol_drugs s:protocol_drugs) {
            uniqueValues.add(s.getName());
        }

        return uniqueValues;
    }


}
