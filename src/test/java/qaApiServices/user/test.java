package qaApiServices.user;

import org.testng.annotations.Test;
import qaApiServices.user.builder.User;
import qaApiServices.user.request.UserPostRequest;
import qaApiServices.user.response.UserResponse;

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
