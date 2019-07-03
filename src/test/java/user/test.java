package user;

import org.testng.annotations.Test;

public class test {
    @Test
    public void test(){
        User build = new User.Builder().build();
        UserPostRequest userPostRequest= new UserPostRequest(build);
        UserResponse userResponse=new UserClient().registerNewUser(userPostRequest);

        System.out.println(userResponse.getUser().getId());
        System.out.println(userResponse.getUser().getPhone_number()
        );
    }
}
