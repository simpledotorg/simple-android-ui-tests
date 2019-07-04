package qaApiServices.protocolDrug;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProtocolDrugRequestBody {
    private List<Prescription_drugs> prescription_drugs;

    public ProtocolDrugRequestBody(List<Prescription_drugs> prescription_drugs) {
        this.prescription_drugs = prescription_drugs;
    }
}
