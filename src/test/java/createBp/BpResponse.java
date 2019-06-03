package createBp;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BpResponse {
    private List<String> errors;
}
