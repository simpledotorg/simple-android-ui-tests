package qaApiServices.user.builder;

import com.embibe.optimus.utils.ScenarioContext;
import lombok.Getter;
import lombok.Setter;
import utils.*;

@Getter
@Setter
public class User {
    private String full_name;
    private String registration_facility_id;
    private String updated_at;
    private String created_at;
    private String phone_number;
    private String id;
    private String password_digest;
    private String deleted_at;
    private String sync_approval_status_reason;
    private String sync_approval_status;

    User(){}

    public User(String full_name, String registration_facility_id, String updated_at, String created_at, String phone_number, String id, String password_digest, String deleted_at) {
        this.full_name = full_name;
        this.registration_facility_id = registration_facility_id;
        this.updated_at = updated_at;
        this.created_at = created_at;
        this.phone_number = phone_number;
        this.id = id;
        this.password_digest = password_digest;
        this.deleted_at = deleted_at;
    }

    public static class Builder {
        String full_name = new CreateFaker().faker.name().firstName();
        String registration_facility_id = "2f086ff7-83dc-4758-bd31-9d9109df9a09";
        String updated_at = Date.getCurrentDateIn_RFC339_Format();
        String created_at = Date.getCurrentDateIn_RFC339_Format();
        String phone_number = RandomValue.getRandomPhoneNumber();
        String id =CreateGenerex.generex.random();
        String password_digest = "$2a$10$vJkbmZrjKDJh1jk1y8HJhuzLAzoY.8p0GfIpNjCNqKvOQh6.ArpYK";
        String deleted_at = "";

        public User build() {
            ScenarioContext.putData("User", ScenarioContextKeys.FACILTIYID, registration_facility_id);
            return new User(full_name, registration_facility_id, updated_at, created_at, phone_number, id, password_digest, deleted_at);
        }
    }
}
