package qaApiServices.user.request;

import lombok.Getter;
import lombok.Setter;
import qaApiServices.user.builder.User;

@Getter
@Setter
public class UserPostRequest {
    private User user;

    public UserPostRequest(User user) {
        this.user = user;
    }
}
