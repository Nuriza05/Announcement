package peaksoft.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.model.Announcement;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public interface AnnouncementRepo extends JpaRepository<Announcement,Long> {

}
