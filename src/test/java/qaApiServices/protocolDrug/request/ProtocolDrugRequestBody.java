package qaApiServices.protocolDrug.request;

import lombok.Getter;
import lombok.Setter;
import qaApiServices.protocolDrug.builder.Prescription_drugs;

import java.util.List;

@Getter
@Setter
public class ProtocolDrugRequestBody {
    private List<Prescription_drugs> prescription_drugs;

    public ProtocolDrugRequestBody(List<Prescription_drugs> prescription_drugs) {
        this.prescription_drugs = prescription_drugs;
    }
}
