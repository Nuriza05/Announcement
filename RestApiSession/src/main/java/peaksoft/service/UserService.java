package peaksoft.service;

import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.model.User;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public interface UserService {
    SimpleResponse save(UserRequest userRequest);
    List<UserResponse> getAll();
    UserResponse getById(Long userId);
    SimpleResponse deleteById(Long userId);
    User update(Long userId,User user);
}
