package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @created : Lenovo Nuriza
 **/
@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private String image;
    private String fullName;
    private String email;

}
