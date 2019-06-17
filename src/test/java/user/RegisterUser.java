package user;

import com.embibe.optimus.utils.ScenarioContext;
import org.testng.annotations.Test;
import utils.ScenarioContextKeys;

public class RegisterUser {

    public void registerNewUser(){
        UserRequestBody userRequestBody=new UserRequestBody.Builder().build();
        UserResponse userResponse=new UserClient().registerNewUser(userRequestBody);

        ScenarioContext.putData("User", ScenarioContextKeys.USER_ID, userResponse.getUser().getId());
        ScenarioContext.putData("User", ScenarioContextKeys.USER_PHONENUMBER, userResponse.getUser().getPhone_number());
        ScenarioContext.putData("User", ScenarioContextKeys.ACCESS_TOKEN, userResponse.getAccess_token());
        ScenarioContext.putData("User", ScenarioContextKeys.FACILTIYID, userResponse.getUser().getRegistration_facility_id());
    }
}
