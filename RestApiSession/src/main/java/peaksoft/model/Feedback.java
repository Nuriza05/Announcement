package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

/**
 * @created : Lenovo Nuriza
 **/
@Entity
@Table(name = "feedbacks")
@Getter
@Setter
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> images;
    private Integer rating;
    private String description;
    private LocalDate createdAt;
    @ManyToOne(cascade = {DETACH,REFRESH,PERSIST,REFRESH},fetch = FetchType.EAGER)
    private Announcement announcement;
    @ManyToOne(cascade = {DETACH,REFRESH,PERSIST,REFRESH},fetch = FetchType.EAGER)
    private User owner;
}
