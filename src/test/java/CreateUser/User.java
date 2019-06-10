package CreateUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String sync_approval_status_reason;
    private String full_name;
    private String registration_facility_id;
    private String updated_at;
    private String created_at;
    private String phone_number;
    private String id;
    private String password_digest;
    private String deleted_at;
    private String sync_approval_status;

}
