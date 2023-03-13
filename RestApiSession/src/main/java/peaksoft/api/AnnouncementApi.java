package peaksoft.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.AnnouncementRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.model.Announcement;
import peaksoft.service.AnnouncementService;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
@RestController
@RequestMapping("/api/announcements")
public class AnnouncementApi {
    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementApi(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }


    @GetMapping
    public List<Announcement> getAll(){
        return announcementService.getAll();
    }
    @PostMapping
    public SimpleResponse save(@RequestBody AnnouncementRequest request) {
        return announcementService.save(request);
    }

    @GetMapping("/{annId}")
    public Announcement getById(@PathVariable Long annId){
        return announcementService.getById(annId);
        
    }

}
