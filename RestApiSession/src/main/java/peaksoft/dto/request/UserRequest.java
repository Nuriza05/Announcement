package peaksoft.dto.request;

import jakarta.persistence.Column;

/**
 * @created : Lenovo Nuriza
 **/
public record UserRequest(
         String image,
         String fullName,
         String email,
         String password
) {
}
