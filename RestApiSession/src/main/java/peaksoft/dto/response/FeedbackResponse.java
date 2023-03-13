package peaksoft.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import peaksoft.model.User;

import java.time.LocalDate;
import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
@Getter
@Setter
@AllArgsConstructor
public class FeedbackResponse {
    private List<String> images;
    private Integer rating;
    private String description;
    private LocalDate createdAt;
    private User owner;

}
