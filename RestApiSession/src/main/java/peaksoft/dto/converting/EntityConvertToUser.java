package peaksoft.dto.converting;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.UserRequest;
import peaksoft.model.User;

/**
 * @created : Lenovo Nuriza
 **/
@Component
public class EntityConvertToUser implements Convert<User, UserRequest> {
    @Override
    public User convert(UserRequest userRequest) {
        User user = new User();
        user.setImage(userRequest.image());
        user.setFullName(userRequest.fullName());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        return user;
    }
}
