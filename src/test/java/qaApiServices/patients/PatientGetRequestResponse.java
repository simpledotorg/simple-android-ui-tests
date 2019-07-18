package qaApiServices.patients;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class PatientGetRequestResponse {
    private List<Patients> patients;
    private String process_token;

    public List<String> getAllPatientsName(){
        List<String> collect = patients.stream()
                .map(p -> p.getFull_name().toUpperCase())
                .collect(Collectors.toList());
        return collect;
    }
}
