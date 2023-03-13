package peaksoft.dto.request;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.HouseType;
import peaksoft.enums.Region;
import peaksoft.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public record AnnouncementRequest(
        List<String> images,
        HouseType housetype,
        Region region,
        BigDecimal price,
        String title,
        String description,
        Integer maxOfGuests,
        String city,
        String address,
        Long ownerId
        ){



}
