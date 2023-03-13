package peaksoft.dto.request;

import jakarta.persistence.ManyToOne;
import peaksoft.model.Announcement;
import peaksoft.model.User;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.REFRESH;

/**
 * @created : Lenovo Nuriza
 **/
public record FeedbackRequest(
         List<String> images,
         Integer rating,
         String description,
         Long ownerId

) {
}
