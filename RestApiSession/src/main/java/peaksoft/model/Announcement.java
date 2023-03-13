package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.HouseType;
import peaksoft.enums.Region;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

/**
 * @created : Lenovo Nuriza
 **/
@Entity
@Table(name = "announcements")
@Getter
@Setter
@NoArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> images;
    @Enumerated(EnumType.STRING)
    private HouseType houseType;
    @Enumerated(EnumType.STRING)
    private Region region;
    private String title;
    private String description;
    private Integer maxOfGuests;
    private BigDecimal price;
    private String city;
    private String address;
    private Double rating;
    private LocalDate createdAt;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "announcement",fetch = FetchType.LAZY)
    private List<Feedback> feedbacks;
    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH},fetch = FetchType.EAGER)
    private User owner;

}
