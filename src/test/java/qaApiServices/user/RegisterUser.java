package qaApiServices.user;

import com.embibe.optimus.utils.ScenarioContext;
import qaApiServices.user.builder.User;
import qaApiServices.user.request.UserPostRequest;
import qaApiServices.user.response.UserResponse;
import utils.ScenarioContextKeys;

public class RegisterUser {

    public void registerNewUser(){
        User build=new User.Builder().build();
        UserPostRequest userPostRequest= new UserPostRequest(build);

        UserResponse userResponse=new UserClient().registerNewUser(userPostRequest);

        ScenarioContext.putData("User", ScenarioContextKeys.USER_ID, userResponse.getUser().getId());
        ScenarioContext.putData("User", ScenarioContextKeys.USER_PHONENUMBER, userResponse.getUser().getPhone_number());
        ScenarioContext.putData("User", ScenarioContextKeys.ACCESS_TOKEN, userResponse.getAccess_token());
        ScenarioContext.putData("User", ScenarioContextKeys.FACILTIYID, userResponse.getUser().getRegistration_facility_id());
        ScenarioContext.putData("User", ScenarioContextKeys.USER_NAME, userResponse.getUser().getFull_name());
    }

    public void registerNewUserWithFacility(){
        User build=new User.Builder().withFacility("1bb26c0b-e0cb-4d5e-8582-47095a3e18bc").build();
        UserPostRequest userPostRequest= new UserPostRequest(build);

        UserResponse userResponse=new UserClient().registerNewUser(userPostRequest);

        ScenarioContext.putData("User", ScenarioContextKeys.USER_ID, userResponse.getUser().getId());
        ScenarioContext.putData("User", ScenarioContextKeys.USER_PHONENUMBER, userResponse.getUser().getPhone_number());
        ScenarioContext.putData("User", ScenarioContextKeys.ACCESS_TOKEN, userResponse.getAccess_token());
        ScenarioContext.putData("User", ScenarioContextKeys.FACILTIYID, userResponse.getUser().getRegistration_facility_id());
        ScenarioContext.putData("User", ScenarioContextKeys.USER_NAME, userResponse.getUser().getFull_name());
    }
}
