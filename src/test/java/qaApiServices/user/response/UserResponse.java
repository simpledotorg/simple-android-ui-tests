package qaApiServices.user.response;

import lombok.Getter;
import lombok.Setter;
import qaApiServices.user.builder.User;

@Getter
@Setter
public class UserResponse {
    private String access_token;
    private User user;
}
