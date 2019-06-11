package CreateUser;

import lombok.Getter;
import lombok.Setter;
import utils.RandomValue;

@Getter
@Setter
public class UserRequestBody {

    private String full_name;
    private String registration_facility_id;
    private String updated_at;
    private String created_at;
    private String phone_number;
    private String id;
    private String password_digest;

    public UserRequestBody(String full_name, String registration_facility_id, String updated_at, String created_at, String phone_number, String id, String password_digest) {
        this.full_name = full_name;
        this.registration_facility_id = registration_facility_id;
        this.updated_at = updated_at;
        this.created_at = created_at;
        this.phone_number = phone_number;
        this.id = id;
        this.password_digest = password_digest;
    }

    public static class Builder {
        String full_name = RandomValue.getRandomUserName();
        String registration_facility_id = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String updated_at = "2019-05-29T06:48:45Z";
        String created_at = "2019-05-29T06:48:45Z";
        String phone_number = RandomValue.getRandomPhoneNumber();
        String id = RandomValue.getRandomUserId();
        String password_digest = "$2a$10$vJkbmZrjKDJh1jk1y8HJhuzLAzoY.8p0GfIpNjCNqKvOQh6.ArpYK";

        public UserRequestBody build() {
            return new UserRequestBody(full_name, registration_facility_id, updated_at, created_at, phone_number, id, password_digest);
        }
    }
}
