package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

/**
 * @created : Lenovo Nuriza
 **/
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "user_id_gen",sequenceName = "user_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
    private Long id;
    private String image;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String password;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner",fetch = FetchType.EAGER)
    private List<Announcement> announcements;
    @JsonIgnore
    @OneToMany(cascade = {REFRESH,DETACH,MERGE,PERSIST} ,mappedBy = "owner")
    private List<Feedback> feedbacks;
}
