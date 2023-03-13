package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dto.converting.EntityConvertingToDto;
import peaksoft.dto.request.AnnouncementRequest;
import peaksoft.model.Announcement;
import peaksoft.model.Feedback;
import peaksoft.model.User;
import peaksoft.repositoy.AnnouncementRepo;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.repositoy.UserRepo;
import peaksoft.service.AnnouncementService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @created : Lenovo Nuriza
 **/
@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepo announcementRepo;
    public final EntityConvertingToDto converting;
    private final UserRepo userRepo;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepo announcementRepo, EntityConvertingToDto converting, UserRepo userRepo) {
        this.announcementRepo = announcementRepo;
        this.converting = converting;
        this.userRepo = userRepo;
    }

    @Override
    public SimpleResponse save(AnnouncementRequest request) {
        Announcement ann = converting.convert(request);
        announcementRepo.save(ann);
        return new SimpleResponse(
                "SAVE",
                String.format("Announcement with name : %s saved!", ann.getTitle())
        );
    }


    @Override
    public List<Announcement> getAll() {
        return announcementRepo.findAll();
    }

    @Override
    public Announcement getById(Long annId) {
        return announcementRepo.findById(annId).orElseThrow(() ->
                new NoSuchElementException("Announcement with id: " + annId + " is not exist!"));
    }

    @Override
    public Announcement assign(Long annId, Long ownerId) {
        Announcement announcement = announcementRepo.findById(annId).orElseThrow(() -> new NoSuchElementException("Announcement with id: " + annId + " is not exist!"));
        User user = userRepo.findById(ownerId).orElseThrow(() -> new NoSuchElementException("User with id: " + ownerId + " is not exist!"));
        announcement.setOwner(user);
        return announcementRepo.save(announcement);

    }


//    public Double ratingCount(Announcement a){
//        Integer rating = 0;
//        Integer count = 0;
//        for (Feedback feedback : a.getFeedbacks()) {
//                count++;
//                rating += feedback.getRating();
//
//            }
//            return (double) (rating / count);
//        }
}
