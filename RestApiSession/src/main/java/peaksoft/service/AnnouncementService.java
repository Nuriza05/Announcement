package peaksoft.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.AnnouncementRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.model.Announcement;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
@Service
@Transactional
public interface AnnouncementService {
    SimpleResponse save(AnnouncementRequest request);
    List<Announcement> getAll();
    Announcement getById(Long annId);
    Announcement assign(Long annId,Long ownerId);
//    Announcement findById(Long announcementId);
//    String deleteById(Long announcementId);
}
