package CreateUser;

import utils.RandomValue;


public class UserRequestBodyBuilder {
    private UserRequestBody request;

    public UserRequestBodyBuilder() {
        request = new UserRequestBody();
        request.setCreated_at("2019-05-29T06:48:45Z");
        request.setPhone_number(RandomValue.getRandomPhoneNumber());
        request.setFull_name(RandomValue.getRandomUserName());
        request.setId(RandomValue.getRandomUserId());
        request.setPassword_digest("$2a$10$vJkbmZrjKDJh1jk1y8HJhuzLAzoY.8p0GfIpNjCNqKvOQh6.ArpYK");
        request.setRegistration_facility_id("2f086ff7-83dc-4758-bd31-9d9109df9a09");
        request.setUpdated_at("2019-05-29T06:48:45Z");
    }

    public UserRequestBody  build(){ return request;}
}
