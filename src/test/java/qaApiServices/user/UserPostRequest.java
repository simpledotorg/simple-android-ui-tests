package qaApiServices.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostRequest {
    private User user;

    public UserPostRequest(User user) {
        this.user = user;
    }
}
