package createBps;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BpRequestBody {
    private List<Blood_pressures> blood_pressures;

    public BpRequestBody(List<Blood_pressures> blood_pressures) {
        this.blood_pressures = blood_pressures;
    }
}
