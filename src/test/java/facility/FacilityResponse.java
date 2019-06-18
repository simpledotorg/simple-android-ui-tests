package facility;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FacilityResponse {
    private List<Facilities> facilities;
    private String process_token;

    public String getProtocolId(String facilityId){
        return facilities.stream().filter(t -> t.getId().equals(facilityId)).collect(Collectors.toList()).get(0).
                getProtocol_id();
    }
}
