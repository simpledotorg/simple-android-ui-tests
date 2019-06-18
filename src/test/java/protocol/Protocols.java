package protocol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Protocols {
    private Protocol_drugs[] protocol_drugs;
    private String updated_at;
    private String name;
    private String follow_up_days;
    private String created_at;
    private String id;
    private String deleted_at;
}
