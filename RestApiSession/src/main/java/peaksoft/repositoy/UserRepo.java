package peaksoft.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.UserResponse;
import peaksoft.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @created : Lenovo Nuriza
 **/
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("select new peaksoft.dto.response.UserResponse(u.image,u.fullName,u.email) from User u")
    List<UserResponse> getAllUsers();
    @Query("select new peaksoft.dto.response.UserResponse(u.image,u.fullName,u.email) from User u where u.id=?1")
    Optional<UserResponse> getUsersById(Long userId);
}
