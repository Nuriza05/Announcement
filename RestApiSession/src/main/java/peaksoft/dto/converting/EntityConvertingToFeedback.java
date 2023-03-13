package peaksoft.dto.converting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import peaksoft.dto.request.FeedbackRequest;
import peaksoft.model.Announcement;
import peaksoft.model.Feedback;
import peaksoft.model.User;
import peaksoft.repositoy.AnnouncementRepo;
import peaksoft.repositoy.UserRepo;

import java.time.LocalDate;
import java.util.NoSuchElementException;

/**
 * @created : Lenovo Nuriza
 **/
@Component
public class EntityConvertingToFeedback implements Convert<Feedback, FeedbackRequest>{
    private final UserRepo userRepo;
    @Autowired
    public EntityConvertingToFeedback(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Feedback convert(FeedbackRequest feedbackRequest) {
        User user = userRepo.findById(feedbackRequest.ownerId()).orElseThrow(() -> new NoSuchElementException("Owner with id: " + feedbackRequest.ownerId() + " is not exist!"));
        Feedback feedback = new Feedback();
        feedback.setImages(feedbackRequest.images());
        feedback.setCreatedAt(LocalDate.now());
        feedback.setImages(feedbackRequest.images());
        feedback.setDescription(feedbackRequest.description());
        feedback.setOwner(user);
        feedback.setRating(feedbackRequest.rating());
        return feedback;
    }
}
