package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.model.User;
import peaksoft.service.UserService;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
@RestController
@RequestMapping("/api/users")
public class UserApi {
    private final UserService userService;
    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAll(){
    return userService.getAll();
    }
    @PostMapping
    public SimpleResponse save(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

    @GetMapping("/{userId}")
    public UserResponse getById(@PathVariable Long userId){
     return userService.getById(userId);
    }

    @DeleteMapping("/{userId}")
    public SimpleResponse deleteById(@PathVariable Long userId){
        return userService.deleteById(userId);
    }

    @PutMapping("{userId}")
    public User update(@PathVariable Long userId, @RequestBody User user){
        return userService.update(userId,user);
    }
}
