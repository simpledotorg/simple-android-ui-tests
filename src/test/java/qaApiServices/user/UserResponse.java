package qaApiServices.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String access_token;
    private User user;
}
