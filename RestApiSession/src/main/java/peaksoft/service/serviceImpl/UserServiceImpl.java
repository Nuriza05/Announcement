package peaksoft.service.serviceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dto.converting.EntityConvertToUser;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.model.User;
import peaksoft.repositoy.UserRepo;
import peaksoft.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @created : Lenovo Nuriza
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final EntityConvertToUser converting;
     @Autowired
    public UserServiceImpl(UserRepo userRepo, EntityConvertToUser converting) {
        this.userRepo = userRepo;
        this.converting = converting;
    }

    @Override
    public SimpleResponse save(UserRequest userRequest) {
        User user = converting.convert(userRequest);
        userRepo.save(user);
        return new SimpleResponse("Save", String.format("USer with name:  %s saved!",user.getFullName()));
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepo.getAllUsers();
    }

    @Override
    public UserResponse getById(Long userId) {
        return userRepo.getUsersById(userId).orElseThrow(()-> new NoSuchElementException("User with id: "+ userId+" doesn't exist!"));
    }

    @Override
    public SimpleResponse deleteById(Long userId) {
        boolean exist = userRepo.existsById(userId);
        if (!exist) {
            throw new NoSuchElementException("User with id: "+ userId+" doesn't exist!");
        }else {
           userRepo.deleteById(userId);
        }
        return new SimpleResponse("DELETE","User with id: " +userId +" is deleted!");
    }

    @Override
    public User update(Long userId, User user) {
        User user1 = userRepo.findById(userId).orElseThrow(()-> new NoSuchElementException("User with id: "+ userId+" doesn't exist!"));
        user1.setFullName(user.getFullName());
        user1.setImage(user.getImage());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        userRepo.save(user1);
        return user1;
    }
}
