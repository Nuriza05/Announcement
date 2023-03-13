package peaksoft.dto.converting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import peaksoft.dto.request.AnnouncementRequest;
import peaksoft.model.Announcement;
import peaksoft.model.User;
import peaksoft.repositoy.UserRepo;

import java.time.LocalDate;
import java.util.NoSuchElementException;

/**
 * @created : Lenovo Nuriza
 **/
@Component
public class EntityConvertingToDto implements Convert<Announcement, AnnouncementRequest> {
    private final UserRepo userRepo;

    @Autowired
    public EntityConvertingToDto(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public Announcement convert(AnnouncementRequest request) {
        User user = userRepo.findById(request.ownerId()).orElseThrow(() -> new NoSuchElementException("User with id: " + request.ownerId() + " is not exist!"));
        Announcement announcement = new Announcement();
        announcement.setImages(request.images());
        announcement.setTitle(request.title());
        announcement.setCity(request.city());
        announcement.setAddress(request.address());
        announcement.setHouseType(request.housetype());
        announcement.setMaxOfGuests(request.maxOfGuests());
        announcement.setPrice(request.price());
        announcement.setDescription(request.description());
        announcement.setCreatedAt(LocalDate.now());
        announcement.setRegion(request.region());
        announcement.setOwner(user);
        return announcement;
    }
}
