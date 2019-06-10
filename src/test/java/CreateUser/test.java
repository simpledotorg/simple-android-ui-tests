package CreateUser;

import org.testng.annotations.Test;

public class test {
    @Test
    public void test(){
        UserRequestBody userRequestBody=new UserRequestBody.Builder().build();
        UserResponse userResponse=new UserClient().registerNewUser(userRequestBody);

        System.out.println(userResponse.getUser().getId());
        System.out.println(userResponse.getUser().getPhone_number()
        );
    }
}
